package com.ganggang.Thread;

import java.util.List;

import org.jsoup.nodes.Document;

import com.ganggang.Dao.CamelListUrlDao;
import com.ganggang.Entity.CamelListUrl;
import com.ganggang.Util.JsoupUtil;

public class AmazonCommentProducer extends Producer {
	private static String commentUrl = "http://www.amazon.com/review/%s/ref=sr_1_1_cm_cr_acr_txt?ie=UTF8&showViewpoints=1";

	public AmazonCommentProducer(CamelUrlContainer container) {
		super(container);
	}

	@Override
	public List<CamelListUrl> GetData() {
		return CamelListUrlDao.GetUnSpiderAmazonComments(10);
	}

	@Override
	public CamelUrl Go(CamelListUrl camelListUrl) {
		String url = String.format(commentUrl, camelListUrl.getAmazonID());
		try {
			Document doc = JsoupUtil.GetDocument(url);
			CamelUrl camelUrl = new CamelUrl();
			camelUrl.setAmazonId(camelListUrl.getAmazonID());
			camelUrl.setCamelListUrl(camelListUrl);
			camelUrl.setDoc(doc);
			return camelUrl;
		} catch (Exception e) {
			camelListUrl.setAmazonFlag(2);
			CamelListUrlDao.Update(camelListUrl);
		}
		return null;
	}
}
