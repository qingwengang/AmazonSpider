package com.ganggang.Proxy;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.ganggang.DO.Box.BoxCategory;
import com.ganggang.Dao.Box.BoxCategoryDao;
import com.ganggang.Dao.Box.BoxProductDao;
import com.ganggang.Entity.Box.BoxProduct;
import com.ganggang.Thread.Base.Container;
import com.ganggang.Thread.Base.ContainerDO;
import com.ganggang.Util.JsoupUtil;

public class BoxzProxy {
	public static void GetBoxCategory(String name, String id) {
		Document doc = JsoupUtil.GetDocument(String.format(
				"http://www.boxz.com/go3c/ajaxLoadCategory.ldo?v=%s&id=%s",
				name, id));
		String a = doc.text();
		JSONArray jj = JSONArray.fromObject(a);
		// System.out.println(jj.get(0));
		for (int i = 0; i < jj.size(); i++) {
			JSONObject obj = JSONObject.fromObject(jj.get(i).toString());
			BoxCategory emp = (BoxCategory) JSONObject.toBean(obj,
					BoxCategory.class);
			if(emp.getChildren().size()<=0){
				com.ganggang.Entity.Box.BoxCategory cate = new com.ganggang.Entity.Box.BoxCategory();
				cate.setBoxCategoryId(emp.getId());
				cate.setName(emp.getName());
				cate.setType(name);
				BoxCategoryDao.Add(cate);
			}
			// System.out.println(emp);
			// System.out.println(emp.getId());
			// System.out.println(emp.getName());
			// System.out.println(emp.getChildren());
			for (Object cdo : emp.getChildren()) {
				String ss = cdo.toString();
				int start = ss.indexOf("id=");
				int end = ss.indexOf(",");
				String c = ss.substring(start + 3, end);
				System.out.println(ss.substring(start + 3, end));
				int s0 = ss.indexOf("name=");
				int s1 = ss.indexOf("}");
				String Name = ss.substring(s0 + 5, s1);
				System.out.println(Name);
				com.ganggang.Entity.Box.BoxCategory cate = new com.ganggang.Entity.Box.BoxCategory();
				cate.setBoxCategoryId(c);
				cate.setFlag(0);
				cate.setName(Name);
				cate.setType(name);
				BoxCategoryDao.Add(cate);
			}
		}
	}

	public static void GetUrl(Container container, ContainerDO containerDo) {
		com.ganggang.Entity.Box.BoxCategory category = (com.ganggang.Entity.Box.BoxCategory) containerDo
				.getEntity();
		Document doc = containerDo.getDoc();
		Elements eTrs = doc.getElementsByTag("tbody").get(0)
				.getElementsByTag("tr");
		for (int i = 1; i < eTrs.size() - 2; i++) {
			String outID = GetOutID(category, eTrs.get(i).select(".eNo8")
					.get(0).getElementsByTag("a").get(0).attr("href"));
			String type = category.getType();
			if (container.AddId(type + outID)) {
				BoxProduct product = new BoxProduct();
				product.setName(eTrs.get(i).select(".eNo1").get(0)
						.getElementsByTag("a").text());
				product.setCurrentPrice(eTrs.get(i).select(".eNo2").get(0)
						.text());
				product.setCategoryId(String.valueOf(category.getId()));
				product.setType(type);
				product.setOutId(outID);
				BoxProductDao.Add(product);
				System.out.println("add success");
			}
		}
	}

	private static String GetOutID(
			com.ganggang.Entity.Box.BoxCategory category, String url) {
		String outId = "";
		if (category.getType().equals("360buy")) {
			int begin = url.indexOf("360buy") + 7;
			int end = url.indexOf(".");
			outId = url.substring(begin, end);
		} else {
			int begin = url.indexOf(category.getType())
					+ category.getType().length() + 1;
			int end = url.indexOf(".");
			outId = url.substring(begin, end);
		}
		return outId;
	}

}
