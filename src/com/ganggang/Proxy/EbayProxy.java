package com.ganggang.Proxy;

import java.io.IOException;
import java.util.Map;

import net.sf.json.JSONObject;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.ganggang.DO.Ebay.EbayCommentDO;
import com.ganggang.Dao.Ebay.EbayCategoryDao;
import com.ganggang.Dao.Ebay.EbayDetailDao;
import com.ganggang.Entity.Ebay.EbayCategory;
import com.ganggang.Entity.Ebay.EbayDetail;
import com.ganggang.Util.CommonUtil;
import com.ganggang.Util.FileHelper;
import com.ganggang.Util.JsoupUtil;

public class EbayProxy {
	private static String listUrl="http://www.ebay.com/sch/9355/i.html?_ipg=100&rt=nc";
	private static String commentUrl="http://feedback.ebay.com/ws/eBayISAPI.dll?ViewFeedback2&ftab=FeedbackAsSeller&userid=megan_a69&iid=291165451924&de=off&items=25&interval=0&mPg=1234&page=3";
	public static void main(String[] args) throws IOException {
//		GetId("http://www.ebay.com/itm/Chinese-traditional-Hand-press-250g-Moon-cake-Mold-Adjustable-Thick-and-Thin-/161435463381?pt=LH_DefaultDomain_0&hash=item25964daed5");
		// TODO Auto-generated method stub
//		GetComments(commentUrl);
//		GetList("http://www.ebay.com/sch/9355/i.html?_ipg=200&rt=nc");
//		GetCommentUrl();
//		GetComments();
//		GetList();
//		GetCommentUrl();
		GetComments();
//		EbayDetail det=EbayDetailDao.GetSpiderCommentFlag();
//		System.out.println(det.getComments());
//		GetCommentUrl("http://www.ebay.com/itm/XIAOMI-Hongmi-Red-Rice-1S-4-7-IPS-Qualcomm-8228-Quad-Core-GPS-3G-Smartphone-NEW-/400781018640?pt=Cell_Phones&hash=item5d50690610");
//		http://feedback.ebay.com/ws/eBayISAPI.dll?ViewFeedback&userid=s.tar.t&iid=171481171479&ssPageName=VIP:feedback&ftab=FeedbackAsSeller&rt=nc&_trksid=p2047675.l2560
	}
	//步骤1，获取url
	public static void GetList() throws IOException{
			EbayCategory ebayCategory=EbayCategoryDao.GetUnSpiderCategory();
			while(ebayCategory!=null){
				String url=ebayCategory.getUrl()+"?&_skc=200&rt=nc";
				Document doc=JsoupUtil.GetDocument(url);
				Element eNum=doc.select(".rcnt").get(0);
				String sNum=eNum.text().replace(",","");
				int iNum=Integer.parseInt(sNum);
				int pages=iNum>10000?50:iNum/200;

				for(int i=1;i<pages;i++){
					if(i>1){
						doc=JsoupUtil.GetDocument(url+"&_pgn="+i);
					}
					System.out.println("-----------------------------------------------page"+i);
					Elements eLis=doc.select("#ListViewInner").get(0).children();
					for(Element eLi : eLis){
						if(eLi.select(".lvtitle").size()>0){
						String name=eLi.select(".lvtitle").get(0).select(".vip").text();
						String detailurl=eLi.select(".lvtitle").get(0).select(".vip").attr("href");
						String id=GetId(eLi.select(".lvtitle").get(0).select(".vip").attr("href"));
						EbayDetail detail=new EbayDetail();
						detail.setEbayID(id);
						detail.setName(name);
						detail.setUrl(detailurl);
						EbayDetailDao.AddEbayDetail(detail);
						}
					}
					System.out.println("-----------------------------------------------page"+i);
				}
				ebayCategory.setFlag(1);
				EbayCategoryDao.UpdateEbayCategory(ebayCategory);
				ebayCategory=EbayCategoryDao.GetUnSpiderCategory();
			}
		}
	//步骤2，获取评论url
	public static void GetCommentUrl() throws IOException{
		EbayDetail detail=EbayDetailDao.GetUnSpiderCommentUrlFlag();
		while(detail!=null){
			GetCommentUrl(detail);
			EbayDetailDao.UpdateEbayDetail(detail);
			detail=EbayDetailDao.GetUnSpiderCommentUrlFlag();
		}
	}
	public static void GetCommentUrl(EbayDetail detail) throws IOException{
		Document doc=Jsoup.connect(detail.getUrl()).get();
		detail.setCommentUrl(doc.select(".mbg-l").get(0).select("a").get(0).attr("href"));
		detail.setCommentCount(Integer.parseInt(doc.select(".mbg-l").get(0).select("a").get(0).text()));
		detail.setCommentUrlFlag(1);
		Map<String,String> pams=CommonUtil.URLRequest(doc.select(".mbg-l").get(0).select("a").get(0).attr("href"));
		detail.setUserID(pams.get("userid"));
		detail.setIID(pams.get("iid"));
	}
	//步骤3 获取评论信息
	public static void GetComments() throws IOException{
		EbayDetail detail=EbayDetailDao.GetUnSpiderCommentFlag();
		while(detail!=null){
			EbayCommentDO ebayComment=new EbayCommentDO();
			String url="http://feedback.ebay.com/ws/eBayISAPI.dll?ViewFeedback2&ftab=FeedbackAsSeller&de=off&interval=0&items=200"+"&userid="+detail.getUserID()+"&iid="+detail.getIID();
			int pages=(detail.getCommentCount()+199)/200;
			System.out.println("++++++++++++++++pages:"+pages);
			for(int i=1;i<=pages;i++){
				try{
				GetComments(url+"&page="+i, detail,ebayComment);}catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
			JSONObject jsonObj = JSONObject.fromObject(ebayComment);  
			detail.setCommentFlag(1);
			detail.setComments(jsonObj.toString());
			FileHelper.WriteEbayComments(detail.getUserID(),detail.getIID() , detail.getComments());
			detail.setComments("");
			EbayDetailDao.UpdateEbayDetail(detail);
			detail=EbayDetailDao.GetUnSpiderCommentFlag();
		}
	}
	public static void GetComments(String url,EbayDetail detail,EbayCommentDO ebayComment) throws IOException{
		System.out.println("---------------------------------------"+url);
		Document doc=JsoupUtil.GetDocument(url);//Jsoup.connect(url).get();
		Element eTable=doc.select(".FbOuterYukon").get(0);
		Elements eTrs=eTable.select("tr");
		for(Element e : eTrs){
			if(e.className().equals("")){
				String comment=e.select("td").get(1).text();
				if(!ebayComment.getComments().contains(comment)&&!ebayComment.getUsedComments().contains(comment)){
					ebayComment.getComments().add(comment);
				}
			}
		}
	}
	
	
	
	public static String GetId(String url){
		try{
		int begin=url.lastIndexOf("/")+1;
		int end=url.indexOf('?');
		String id=url.substring(begin, end);
		return id;
		}catch(Exception e){
			System.out.println(url);
			throw e;
		}
		
	}
}
