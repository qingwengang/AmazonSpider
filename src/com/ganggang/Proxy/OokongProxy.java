package com.ganggang.Proxy;

import java.util.List;
import java.util.Set;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.ganggang.DO.Online.PriceDO;
import com.ganggang.DO.Online.PriceDetailDO;
import com.ganggang.DO.Ookong.OokongPriceDO;
import com.ganggang.DO.Unimerc.UnimercPriceDO;
import com.ganggang.Dao.CamelListUrlDao;
import com.ganggang.Entity.CamelListUrl;
import com.ganggang.Thread.CamelUrl;
import com.ganggang.Util.JsoupUtil;
import com.ganggang.Util.LogHelper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class OokongProxy {
	private static String commentUrl="http://www.amazon.com/review/%s/ref=cm_cr_pr_viewpnt#R3DQAUD1NDB06S";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		GetPrices();
//		GetPrice("B0038YXGU6");
	}
//	public static void GetPrices(){
//		List<CamelListUrl> listUrls=CamelListUrlDao.GetUnSpiderOokongPrice();
//		while(listUrls!=null && listUrls.size()>0){
//			for (CamelListUrl listUrl : listUrls) {
//				try {
//					System.out.println(listUrl.getAmazonID());
//					listUrl.setOokongPrice(GetPrice(listUrl.getAmazonID()));
//					listUrl.setOokongPriceFlag(1);
//					CamelListUrlDao.Update(listUrl);
//				} catch (Exception e) {
//					System.out.println(e.getStackTrace());
//					listUrl.setOokongPriceFlag(2);
//					CamelListUrlDao.Update(listUrl);
//				}
//			}
//			listUrls=CamelListUrlDao.GetUnSpiderOokongPrice();
//		}
//	}
	public static void GetPrice(CamelUrl camelUrl){
		try{
		String priceData="";
		String html=camelUrl.getDoc().html();
		int begin=html.indexOf("var item =");
		int end=html.indexOf("var draw");
		if(begin>0 && end>0){
			priceData=html.substring(begin+11, end-3).trim().replace(";","");
		}
		camelUrl.getCamelListUrl().setOokongPrice(priceData);
		camelUrl.getCamelListUrl().setOokongPriceFlag(1);
		System.out.println(priceData);
		CamelListUrlDao.Update(camelUrl.getCamelListUrl());
		}catch(Exception e){
			System.out.println("++++++++++++++++++++++++++++++++++++++=");
			System.out.println(e);
			camelUrl.getCamelListUrl().setOokongPriceFlag(2);
			CamelListUrlDao.Update(camelUrl.getCamelListUrl());
		}
	}
	
	public static void GetBasicData(CamelUrl camelUrl){
		Document doc=camelUrl.getDoc();
		try{
			String priceData="";
			String html=camelUrl.getDoc().html();
			int begin=html.indexOf("var item =");
			int end=html.indexOf("var draw");
			if(begin>0 && end>0){
				priceData=html.substring(begin+11, end-3).trim().replace(";","");
				JSONObject obj=JSONObject.fromObject(priceData);
				Gson gson = new Gson();
				OokongPriceDO emp=gson.fromJson(priceData,new TypeToken<OokongPriceDO>(){}.getType());
				if(emp!=null){
					PriceDO priceDo=new PriceDO();
					Set<Long> priceKyes=emp.getPrices().keySet();
					for(Long key : priceKyes){
						Double value=emp.getPrices().get(key);
						if(value!=null){
							priceDo.getAmazonPrices().add(new PriceDetailDO(key, value));
						}
					}
					Set<Long> thirdKeys=emp.getThirdPartyNewPrices().keySet();
					for(Long key : thirdKeys){
						Double value=emp.getPrices().get(key);
						if(value!=null){
						priceDo.getThirdPartyPrice().add(new PriceDetailDO(key, value));
						}
					}
					JSONArray jsonArray = JSONArray.fromObject( priceDo);  
					String onlineData=jsonArray.toString();
					camelUrl.getCamelListUrl().setOokongPrice(onlineData);
					camelUrl.getCamelListUrl().setOokongPriceFlag(100);
					CamelListUrlDao.Update(camelUrl.getCamelListUrl());
				}
			}
		}catch(Exception e){
			camelUrl.getCamelListUrl().setOokongPriceFlag(2);
			CamelListUrlDao.Update(camelUrl.getCamelListUrl());
			LogHelper.AddLog("OokongProxy.GetBasicData",camelUrl.getDoc().html()+e.getMessage() );
		}
	}
}
