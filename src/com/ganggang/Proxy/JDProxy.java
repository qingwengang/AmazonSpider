package com.ganggang.Proxy;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.ganggang.Dao.Box.BoxProductDao;
import com.ganggang.Entity.Box.BoxProduct;
import com.ganggang.Thread.Base.ContainerDO;
import com.ganggang.Util.JsoupUtil;

public class JDProxy {
	private static String directUrl="http://www.boxz.com/go3c/redirect.ldo?v=%s&id=%s&r=3";
	private static String detailUrl = "http://item.jd.com/%s.html#product-detail";
	private static String icsonDetailUrl = "http://item.yixun.com/item-%s.html";
	private static String yhdDetailUrl = "http://item.yhd.com/product/%s";
	private static String amazonDetailUrl = "http://www.amazon.cn/mn/detailApp?_encoding=UTF8&tag=boxz-23&linkCode=as2&asin=%s";
	private static String suningDetailUrl = "http://product.suning.com/%s.html";

	// public static void GetDetail(String id){
	// Document doc=JsoupUtil.GetDocument(String.format(detailUrl, id));
	// System.out.println(doc.getElementById("product-detail-1").select(".detail-list").get(0).getElementsByTag("li").size());
	// Elements
	// lis=doc.getElementById("product-detail-1").select(".detail-list").get(0).getElementsByTag("li");
	// for(Element li : lis){
	// System.out.println(li.text());
	// }
	// // return detail;
	// System.out.println("over");
	// }
	public static Document GetDetailDocument(BoxProduct product) {
		String url = "";
		if (product.getType().equals("360buy")) {
			url = String.format(detailUrl, product.getOutId());
		} else if (product.getType().equals("icson")) {
			url = String.format(icsonDetailUrl, product.getOutId());
		} else if (product.getType().equals("yihaodian")) {
			url = String.format(yhdDetailUrl, product.getOutId());
		} else if (product.getType().equals("amazon")) {
			url = String.format(amazonDetailUrl, product.getOutId());
		}else if (product.getType().equals("suning")) {
			url = String.format(suningDetailUrl, product.getOutId());
		}else if (product.getType().equals("gome")) {
			String dirUrl = String.format(directUrl, "19",product.getOutId());
			Document doc=JsoupUtil.GetDocument(dirUrl);
			Elements metas=doc.getElementsByTag("meta");
			for(Element meta:metas){
				if(meta.attr("http-equiv").equals("refresh")){
					String metaUrl=meta.attr("content");
					url=metaUrl.substring(metaUrl.indexOf("to=")+3,metaUrl.length());
				}
			}
		}
		Document doc = JsoupUtil.GetDocument(url);
		return doc;
	}

	public static void GetDetailDocument(ContainerDO containerDo) {
		BoxProduct product = (BoxProduct) containerDo.getEntity();
		StringBuilder sbDetail = new StringBuilder();
		Document doc = containerDo.getDoc();
		if (product.getType().equals("360buy")) {
			Elements lis = doc.getElementById("product-detail-1")
					.select(".detail-list").get(0).getElementsByTag("li");
			for (Element li : lis) {
				sbDetail.append(li.text() + "|");
			}
		} else if (product.getType().equals("icson")) {
			Elements tbs = doc.select(".specification");
			if (tbs.size() > 0) {
				Element tb = tbs.get(0);
				Elements trs = tb.getElementsByTag("tr");
				for (Element tr : trs) {
					if (tr.children().size() == 2) {
						sbDetail.append(tr.select(".name").get(0).text())
								.append(":")
								.append(tr.select(".desc").get(0).text())
								.append("|");
					}
				}
			}
		} else if (product.getType().equals("yihaodian")) {
			Elements dls = doc.select(".des_info");
			if (dls.size() > 0) {
				Elements dds = dls.get(0).getElementsByTag("dd");
				for (Element dd : dds) {
					sbDetail.append(dd.attr("title")).append("|");
				}
			}
		} else if (product.getType().equals("amazon")) {
			Element tb = doc.getElementById("productDetailsTable");
			if (tb != null) {
				Elements content = tb.select(".content");
				if (content.size() > 0) {
					Element eContent = content.get(0);
					Elements lis = eContent.getElementsByTag("li");
					for (Element li : lis) {
						if (li.text().contains("ÓÃ»§ÆÀ·Ö:")) {
							System.out.println("++++++++++++++++++");
							break;
						}
						sbDetail.append(li.text());
					}
				}
			}
		} else if (product.getType().equals("suning")) {
			Element canshu = doc.getElementById("canshu_box");
			if (canshu != null) {
				Elements tbs = canshu.getElementsByTag("table");
				for (Element tb : tbs) {
					Elements trs=tb.getElementsByTag("tr");
					for(Element tr:trs){
						if(tr.children().size()==3){
							sbDetail.append(tr.children().get(0).text()).append(tr.children().get(1).text()).append("|");
						}
					}
				}
			}
		}
		else if (product.getType().equals("gome")) {
			Elements es=doc.select(".specbox");
			if(es.size()>0){
				Element eul=es.get(0);
				Elements lis=eul.getElementsByTag("li");
				for(Element li:lis){
					if(li.getElementsByTag("span").size()==2){
						sbDetail.append(li.getElementsByTag("span").get(0).text()).append(":").append(li.getElementsByTag("span").get(1).text()).append("|");
					}
				}
			}
		}
		product.setDetailInfo(sbDetail.toString());
		product.setDetailInfoFlag(100);
		BoxProductDao.Update(product);
	}

	public static void main(String[] at) {
		// GetDetail("1314006097");="
		String s = "fdsfqqqqq";
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			if (i > 5) {
				break;
			}
		}
	}

}
