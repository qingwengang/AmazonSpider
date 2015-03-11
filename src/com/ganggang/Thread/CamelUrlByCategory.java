package com.ganggang.Thread;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.ganggang.Dao.CamelCategoryDao;
import com.ganggang.Entity.CamelCategory;
import com.ganggang.Util.JsoupUtil;

public class CamelUrlByCategory implements Runnable {
	private CamelUrlContainer container;

	public CamelUrlContainer getContainer() {
		return container;
	}

	public void setContainer(CamelUrlContainer container) {
		this.container = container;
	}
	
	public synchronized CamelCategory GetUnSpiderCategory(){
		CamelCategory category=CamelCategoryDao.GetUnSpiderCategory();
		category.setFlag(1);
		CamelCategoryDao.UpdateCategory(category);
		return category;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		CamelCategory category=GetUnSpiderCategory();
		while(category!=null){
			String url="http://camelcamelcamel.com/products?mf="+category.getCategoryName();
			Document doc = JsoupUtil.GetDocument(url,"112.125.17.5",8080);
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
									.GetDocument(url +"&p=" + i,"112.125.17.5",8080);
						} catch (Exception e) {
						}
					}
					CamelUrl camelurl = new CamelUrl();
					camelurl.setDoc(doc);
					camelurl.setParentId(category.getId());
					container.Insert(camelurl);
				}
			}
			category=GetUnSpiderCategory();
		}
	}

}
