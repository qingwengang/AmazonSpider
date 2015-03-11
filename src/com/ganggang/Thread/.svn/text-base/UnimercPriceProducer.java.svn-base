package com.ganggang.Thread;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.ganggang.Dao.CamelListUrlDao;
import com.ganggang.Entity.CamelListUrl;
import com.ganggang.Util.JsoupUtil;

public class UnimercPriceProducer implements Runnable {
	private CamelUrlContainer container;

	public CamelUrlContainer getContainer() {
		return container;
	}

	public void setContainer(CamelUrlContainer container) {
		this.container = container;
	}

	public synchronized List<CamelListUrl> GetUnSpinerUnimercListUrl() {
		List<CamelListUrl> listUrls = CamelListUrlDao.GetUnSpiderUnimercPrice();
		return listUrls;
	}

	@Override
	public void run() {
		List<CamelListUrl> listUrls = GetUnSpinerUnimercListUrl();
		while (true) {
			for (CamelListUrl listurl : listUrls) {
				try {
					String url = String.format(
							"http://www.unimerc.com/chart_output.php?sku=%s",
							listurl.getAmazonID());
					Document doc = JsoupUtil.GetDocument(url);
					CamelUrl camelurl = new CamelUrl();
					camelurl.setDoc(doc);
					camelurl.setAmazonId(listurl.getAmazonID());
					camelurl.setCamelListUrl(listurl);
					container.Insert(camelurl);
				} catch (Exception e) {
					listurl.setUnimercPriceFlag(2);
					CamelListUrlDao.Update(listurl);
				}
			}
			listUrls = GetUnSpinerUnimercListUrl();
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
