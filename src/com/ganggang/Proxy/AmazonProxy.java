package com.ganggang.Proxy;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.ganggang.Dao.CamelListUrlDao;
import com.ganggang.Entity.CamelListUrl;
import com.ganggang.Thread.CamelUrl;
import com.ganggang.Util.JsoupUtil;
import com.ganggang.Util.LogHelper;

public class AmazonProxy {
//	private static String commentUrl="http://www.amazon.com/product-reviews/%s/ref=cm_cr_pr_hist_5?ie=UTF8&filterBy=addFiveStar&showViewpoints=0&sortBy=bySubmissionDateDescending";
	private static String commentUrl="http://www.amazon.com/review/%s/ref=sr_1_1_cm_cr_acr_txt?ie=UTF8&showViewpoints=1";
	public static void main(String[] args) throws IOException{
//		GetComments();
//		GetPrice("B002MAPS6W");
//		GetPrices();
	}
//	public static void GetCommentss(CamelUrl camelUrl){
//		CamelListUrl listUrl=CamelListUrlDao.GetUnSpiderAmazonComments();
//		while(listUrl!=null){
//			try {
//				List<String> comments=GetComments(listUrl.getAmazonID());
//				JSONArray  jsonObj = JSONArray.fromObject(comments);  
//				listUrl.setAmazonComment(jsonObj.toString());
//				listUrl.setAmazonFlag(100);
//				CamelListUrlDao.Update(listUrl);
//				System.out.println(jsonObj.toString());
//			} catch (Exception e) {
//				System.out.println(e.getStackTrace());
//				listUrl.setAmazonFlag(2);
//				CamelListUrlDao.Update(listUrl);
//				System.out.println("error");
//			}
//			listUrl=CamelListUrlDao.GetUnSpiderAmazonComments();
//		}
//	}
	  
	public static void GetComments(CamelUrl camelUrl){
		try {
			Document doc = camelUrl.getDoc();
			Elements es=doc.select(".reviewText");
			List<String> comments=new LinkedList<String>();
			for(Element e : es){
				comments.add(e.text());
			}
			JSONArray  jsonObj = JSONArray.fromObject(comments);  
			camelUrl.getCamelListUrl().setAmazonFlag(100);
			camelUrl.getCamelListUrl().setAmazonComment(jsonObj.toString());
			CamelListUrlDao.Update(camelUrl.getCamelListUrl());
		} catch (Exception e) {
			camelUrl.getCamelListUrl().setAmazonFlag(2);
			CamelListUrlDao.Update(camelUrl.getCamelListUrl());
			LogHelper.AddLog("AmazonProxy.GetComments", camelUrl.getAmazonId()+"|"+e.getMessage());
		}
	}
	public static void GetPrices(){
		List<CamelListUrl> listUrls=CamelListUrlDao.GetUnSpiderAmazonPrice(10);
		while(listUrls!=null && listUrls.size()>0){
			for (CamelListUrl listUrl : listUrls) {
				try {
					System.out.println(listUrl.getAmazonID());
					listUrl.setAmazonPrice(GetPrice(listUrl.getAmazonID()));
					listUrl.setAmazonPriceFlag(100);
					CamelListUrlDao.Update(listUrl);
				} catch (Exception e) {
					System.out.println(e.getStackTrace());
					listUrl.setAmazonPriceFlag(2);
					CamelListUrlDao.Update(listUrl);
				}
			}
			listUrls=CamelListUrlDao.GetUnSpiderAmazonPrice(10);
		}
	}
	public static String GetPrice(String ID){
		Document doc = JsoupUtil.GetDocument("http://www.amazon.com/dp/"+ID);
		System.out.println("fds");
		Element ePrice=null;
		if(doc.getElementById("priceblock_ourprice")!=null){
			ePrice=doc.getElementById("priceblock_ourprice");
		}else if(doc.getElementById("priceblock_dealprice")!=null){
			ePrice=doc.getElementById("priceblock_dealprice");
		}else if(doc.getElementById("priceblock_ourprice")!=null){
			ePrice=doc.getElementById("priceblock_ourprice");
		}
		System.out.println(ePrice.text());
		return ePrice.text();
	}
}
