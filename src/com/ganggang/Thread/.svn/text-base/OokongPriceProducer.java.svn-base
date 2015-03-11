package com.ganggang.Thread;

import java.util.List;

import org.jsoup.nodes.Document;

import com.ganggang.Dao.CamelListUrlDao;
import com.ganggang.Entity.CamelListUrl;
import com.ganggang.Proxy.OokongProxy;
import com.ganggang.Util.JsoupUtil;

public class OokongPriceProducer implements Runnable {
	private CamelUrlContainer container;

	public CamelUrlContainer getContainer() {
		return container;
	}

	public void setContainer(CamelUrlContainer container) {
		this.container = container;
	}

	public synchronized List<CamelListUrl> GetUnSpinerOokongListUrl() {
		List<CamelListUrl> listUrls = CamelListUrlDao.GetUnSpiderOokongPrice();
		return listUrls;
	}

	@Override
	public void run() {
		List<CamelListUrl> listUrls = GetUnSpinerOokongListUrl();
		while (true) {
			for (CamelListUrl camelUrl : listUrls) {
				try {
					Document doc = JsoupUtil
							.GetDocument("http://ookong.org/us/p/"
									+ camelUrl.getAmazonID());
					if (doc == null) {
						camelUrl.setOokongPriceFlag(2);
						CamelListUrlDao.Update(camelUrl);
						continue;
					}
					if (doc.select("#error404").size() > 0) {
						camelUrl.setOokongPriceFlag(2);
						CamelListUrlDao.Update(camelUrl);
						continue;
					}
					CamelUrl url = new CamelUrl();
					url.setDoc(doc);
					url.setAmazonId(camelUrl.getAmazonID());
					url.setCamelListUrl(camelUrl);
					container.Insert(url);
				} catch (Exception e) {
					camelUrl.setOokongPriceFlag(2);
					CamelListUrlDao.Update(camelUrl);
				}
			}
			listUrls = GetUnSpinerOokongListUrl();
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
