package com.ganggang.Thread;

import java.io.IOException;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.ganggang.Dao.CamelListUrlDao;
import com.ganggang.Dao.FailUrlDao;
import com.ganggang.Dao.MuluDao;
import com.ganggang.Entity.CamelListUrl;
import com.ganggang.Entity.Mulu;
import com.ganggang.Util.JsoupUtil;
import com.ganggang.Util.Mail.MailProxy;

public class CamelUrlProducer implements Runnable {
	
	public static void main(String[] ar){
		FailUrlDao.AddFailUrl("CamelUrlProducer", "http://camelcamelcamel.com/"+ "fdsf" + "&p=" + 2,2);
	}
	private CamelUrlContainer container;

	public CamelUrlContainer getContainer() {
		return container;
	}

	public void setContainer(CamelUrlContainer container) {
		this.container = container;
	}

	public synchronized Mulu GetUnSpinerMulu() {
		Mulu mulu = MuluDao.GetUnSpiderMulu();
		mulu.setFlag(1);
		MuluDao.UpdateMuluFlag(mulu);
		return mulu;
	}

	@Override
	public void run() {
		try {
			Mulu mulu = GetUnSpinerMulu();
			while (mulu != null) {
				try {
					Document doc = JsoupUtil
							.GetDocument("http://camelcamelcamel.com/"
									+ mulu.getUrl());
					if (doc.select(".pagination").size() > 0) {
						Elements pageLabels = doc.select(".pagination").first()
								.select("a");
						int page = 1;
						if (pageLabels.size() > 0) {
							page = Integer.parseInt(pageLabels
									.get(pageLabels.size() - 2).text().trim());
						}
						for (int i = 1; i <= page; i++) {
							if (i > 1) {
								try {
									doc = JsoupUtil
											.GetDocument("http://camelcamelcamel.com/"
													+ mulu.getUrl() + "&p=" + i);
								} catch (Exception e) {
								}
							}
							if (doc == null)
							{
								FailUrlDao.AddFailUrl("CamelUrlProducer", "http://camelcamelcamel.com/"+ mulu.getUrl() + "&p=" + i,mulu.getId());
							}
							CamelUrl url = new CamelUrl();
							url.setDoc(doc);
							url.setParentId(mulu.getId());
							container.Insert(url);
							System.out.println("+1");
						}
					}
				} catch (Exception e) {

				}
				mulu = GetUnSpinerMulu();
			}
		} catch (Exception ex) {
			System.out.println(ex);
		} finally {

		}
	}
}
