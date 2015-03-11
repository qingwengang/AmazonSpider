package com.ganggang.Thread;

import java.util.List;

import org.jsoup.nodes.Document;

import com.ganggang.Dao.CamelListUrlDao;
import com.ganggang.Dao.MuluDao;
import com.ganggang.Entity.CamelListUrl;
import com.ganggang.Entity.Mulu;
import com.ganggang.Util.JsoupUtil;
import com.ganggang.Util.LogHelper;

public class CamelDeatilProducer implements Runnable {
	private CamelUrlContainer container;

	public CamelUrlContainer getContainer() {
		return container;
	}

	public void setContainer(CamelUrlContainer container) {
		this.container = container;
	}

	public synchronized List<CamelListUrl> GetUnSpinerCamelListUrl() {
		List<CamelListUrl> listUrls = CamelListUrlDao
				.GetUnSpiderCamelListUrl(10);
		return listUrls;
	}

	@Override
	public void run() {
		List<CamelListUrl> listUrls = GetUnSpinerCamelListUrl();
		while (true) {
			for (CamelListUrl camelUrl : listUrls) {
				try{
				Document doc = JsoupUtil.GetDocument(camelUrl.getUrl(),
						"112.125.17.5", 8080);
				if (doc == null) {
					camelUrl.setFlag(2);
					CamelListUrlDao.Update(camelUrl);
					LogHelper.AddLog("CamelDetailProducer.run", "docÎª¿Õ£º"+camelUrl.getUrl());
					continue;
				}
				CamelUrl url = new CamelUrl();
				url.setDoc(doc);
				url.setAmazonId(camelUrl.getAmazonID());
				url.setCamelListUrl(camelUrl);
				container.Insert(url);
				}catch(Exception e){
					camelUrl.setFlag(2);
					CamelListUrlDao.Update(camelUrl);
				}
			}
			listUrls = GetUnSpinerCamelListUrl();
			if (listUrls.size() <= 0) {
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
