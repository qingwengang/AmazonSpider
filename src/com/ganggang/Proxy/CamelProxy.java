package com.ganggang.Proxy;

import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.jsoup.select.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.ganggang.DO.Camel.ProductDetailDO;
import com.ganggang.DO.Camel.ProductPriceDO;
import com.ganggang.DO.Camel.ProductPriceDetailDO;
import com.ganggang.DO.Camel.ProductPriceHistory;
import com.ganggang.Dao.CamelCategoryDao;
import com.ganggang.Dao.CamelListUrlDao;
import com.ganggang.Dao.MuluDao;
import com.ganggang.Entity.CamelCategory;
import com.ganggang.Entity.CamelListUrl;
import com.ganggang.Entity.Mulu;
import com.ganggang.Thread.CamelUrl;
import com.ganggang.Thread.CamelUrlContainer;
import com.ganggang.Util.HibernateUtil;
import com.ganggang.Util.JsoupUtil;
import com.ganggang.Util.LogHelper;
import com.ganggang.Util.Mail.MailProxy;

public class CamelProxy {

	public static void main(String[] args) throws IOException {
//		getUrl("http://camelcamelcamel.com/products");
//		GetList("http://camelcamelcamel.com/products?pc=Board+book",11);
//		GetPriceList("http://camelcamelcamel.com/Fuzzy-Bee-Friends-Cloth-Books/product/0312491506?context=browse");
//		GetAmazonID("http://camelcamelcamel.com/Fuzzy-Bee-Friends-Cloth-Books/product/0312491506?context=browse");
		InitCategory();
//		System.out.println(CamelCategoryDao.GetUnSpiderCategory().getCategoryName());
//		GetAmazonId();
	}
	//出入目录表
	public static void getUrl() throws IOException{
		Document doc =JsoupUtil.GetDocument("http://camelcamelcamel.com/products");// Jsoup.connect("http://camelcamelcamel.com/products").get();
		Elements es=doc.select(".colparent");
		for(Element e : es.get(0).select("li")){
			Mulu m=new Mulu();
			m.setName(e.text().trim());
			m.setUrl(e.childNode(0).attr("href").trim());
			m.setTypeId(0);
			m.setLastUpdateTime(new Date());
			MuluDao.AddMulu(m);
		}
		for(Element e : es.get(1).select("li")){
			Mulu m=new Mulu();
			m.setName(e.text().trim());
			m.setUrl(e.childNode(0).attr("href").trim());
			m.setTypeId(1);
			m.setLastUpdateTime(new Date());
			MuluDao.AddMulu(m);
		}
		MailProxy.SendEmail("init mulu success!!!", "init mulu success!!!");
		System.out.println("init mulu success!!!");
	}
	public static void GetList(CamelUrl camelUrl,CamelUrlContainer container){
		try{
		Element e = camelUrl.getDoc().select("#products_list").get(0);
		Elements es = e.select(".product_small");
		Elements etr = e.select("tr");
		for (Element el : etr) {

			String productName = el.select(".product_title")
					.select("a").first().text();
			String productUrl = el.select(".product_title").select("a")
					.first().attr("href");
			if (container.AddAmazonId(GetAmazonID(productUrl))) {
				String imgSrc = el.select(".product_image")
						.select("img").first().attr("src");
				StringBuilder sbCategory = new StringBuilder();
				Elements esCategory = el.select(".breadcrumbs").first()
						.select("a");
				for (Element eCat : esCategory) {

					sbCategory.append(eCat.text() + "|");
				}
				String category = sbCategory.toString();
				Element esProperty = el.select(".breadcrumbs").first()
						.nextElementSibling();
				String property = esProperty.text();
				CamelListUrl listUrl = new CamelListUrl();
				listUrl.setUrl(productUrl);
				listUrl.setName(productName);
				listUrl.setFlag(0);
				listUrl.setAmazonID(GetAmazonID(productUrl));
				listUrl.setParentID(camelUrl.getParentId());
				listUrl.setLastUpdateTime(new Date());
				listUrl.setImgSrc(imgSrc);
				listUrl.setCategory(category);
				listUrl.setProperty(property);
				CamelListUrlDao.AddCamelListUrl(listUrl);
			} else {
				System.out
						.println("-----------------------------------已经存在！！！！！"
								+ GetAmazonID(productUrl));
			}
		}
		}catch(Exception e){
//			LogHelper.AddLog("CamelProxy.GetList", camelUrl.getDoc().html());
			System.out.println(e);
		}
	}
	public static void GetDetail(CamelUrl camelUrl){
		try{
		Document doc=camelUrl.getDoc();
		ProductPriceDO priceDo=new ProductPriceDO();
		GetProductDetail(doc,priceDo);
		GetAmazonHistory(doc,priceDo);
		camelUrl.getCamelListUrl().setCamelPriceData(JSONArray.fromObject(priceDo).toString());
		camelUrl.getCamelListUrl().setFlag(100);
		CamelListUrlDao.Update(camelUrl.getCamelListUrl());
		}catch(Exception e){
			camelUrl.getCamelListUrl().setFlag(2);
			CamelListUrlDao.Update(camelUrl.getCamelListUrl());
			LogHelper.AddLog("CamelProxy.GetDetail", camelUrl.getDoc().html()+e.getMessage());
		}
	}
	
	public static void GetPriceList(String url) throws IOException{
		Document doc = Jsoup.connect(url).get();
		Elements es=doc.select("#section_amazon").select(".yui3-u-1-2").get(1).select(".history_list").get(0).select("tbody").first().children();
		for(Element e : es){
			System.out.println(e.select("td").first().text());
			System.out.println(e.select("td").get(1).text());
		}
	}
	
	//http://camelcamelcamel.com/Fuzzy-Bee-Friends-Cloth-Books/product/0312491506?context=browse
	public static String GetAmazonID(String url){
		int firstLocation=url.lastIndexOf('/')+1;
		int lastLocation=url.lastIndexOf('?');
		String id=url.substring(firstLocation, lastLocation);
		return id;
	}
	
	public static void InitCategory(){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		List list=session.createSQLQuery("select DISTINCT category from camellisturl order by category ").list();
		for(Iterator iterator =list.iterator();iterator.hasNext();){
			System.out.println(iterator.next());
			try{
			String[] cs=((String)iterator.next()).split("\\|");
			for(int i=0;i<cs.length;i++){
				CamelCategory category=new CamelCategory();
				category.setLevel(i+1);
				category.setCategoryName(cs[i]);
				category.setParentId(0);
				category.setFlag(0);
				CamelCategoryDao.AddCategory(category);
			}
			}catch(Exception e){
				
			}
		}
		session.close();
	}
	
	public static List<String> GetAmazonId(){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		List<String> ls=new LinkedList<String>();
		List list=session.createSQLQuery("select DISTINCT amazonid from camellisturl").list();
		for(Iterator iterator =list.iterator();iterator.hasNext();){
			ls.add((String)iterator.next());
		}
		session.close();
		return ls;
	}
	public static String GetProductDetail(Document doc,ProductPriceDO priceDo){
		StringBuilder sbDetail=new StringBuilder();
		Elements eDetails=doc.select("#section_details");
		if(eDetails.size()>0){
			Element eDetail=eDetails.get(0);
			if(eDetail.select(".product_fields").size()>0){
				Element eTable=eDetail.select(".product_fields").get(0);
				Elements eTrs=eTable.select("tr");
				for(Element etr : eTrs){
					Elements eTds=etr.select("td");
					ProductDetailDO productDetail=new ProductDetailDO();
					productDetail.setName(eTds.get(0).text());
					productDetail.setValue(eTds.get(1).text());
					priceDo.getProductDetails().add(productDetail);
				}
			}
		}
		return "";
	}
	public static void GetAmazonHistory(Document doc,ProductPriceDO priceDo){
		Elements eDetails=doc.select("#section_amazon");
		if(eDetails.size()>0){
			Elements eTb=eDetails.get(0).select("table");
			if(eTb.size()>0){
				//各种价格
				Element eHistory1=eTb.get(0);
				if(eHistory1.select("tbody").size()>0){
					Elements eTrs=eHistory1.select("tbody").get(0).select("tr");
					for(Element eTr : eTrs){
						Elements eTds=eTr.select("td");
						ProductPriceDetailDO priceDetailDo=new ProductPriceDetailDO();
						priceDetailDo.setType(eTds.get(0).text());
						priceDetailDo.setPrice(eTds.get(1).text());
						priceDetailDo.setTime(eTds.get(2).text());
						priceDo.getDetails().add(priceDetailDo);
					}
				}
				//价格历史
				Element eHistory2=eTb.get(1);
				if(eHistory2.select("tbody").size()>0){
					Elements eTrs=eHistory2.select("tbody").get(0).select("tr");
					for(Element eTr : eTrs){
						Elements eTds=eTr.select("td");
						ProductPriceHistory history=new ProductPriceHistory();
						history.setPriceDate(eTds.get(0).text());
						history.setPrice(eTds.get(1).text());
						priceDo.getHistories().add(history);
					}
				}
			}
		}
	}
}

