package com.ganggang.Thread.Box;

import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.ganggang.Dao.Box.BoxCategoryDao;
import com.ganggang.Entity.Base.BaseEntity;
import com.ganggang.Entity.Box.BoxCategory;
import com.ganggang.Thread.CamelUrl;
import com.ganggang.Thread.CamelUrlContainer;
import com.ganggang.Thread.Base.BaseProducer;
import com.ganggang.Thread.Base.Container;
import com.ganggang.Thread.Base.ContainerDO;
import com.ganggang.Util.JsoupUtil;

public class BoxGetUrlProducer extends BaseProducer {
	private String url = "http://www.boxz.com/go3c/category.ldo?v=%s&e=&p=%d&o=dA&s_b=0&lowest=0&districtId=0&categoryId=%s&level=3&ajax=1&sh_f=1&sh_p=1&reduceDays=0&comments=0&random=0.4322997482959181";

	public BoxGetUrlProducer(Container container) {
		super(container);
	}

	@Override
	public List<? extends BaseEntity> GetData() {
		return BoxCategoryDao.GetUnSpiderCategory();
	}

	@Override
	public ContainerDO Go(BaseEntity baseEntity) {
		BoxCategory categorys = (BoxCategory) baseEntity;
		String getUrl = String.format(url, categorys.getType(), 1,
				categorys.getBoxCategoryId());
		Document doc = JsoupUtil.GetDocument(getUrl);
		int num = 0;
		int pages=1;
		Elements hrefs = doc.getElementsByTag("a");
		for (Element e : hrefs) {
			if (e.text().equals(">|")) {
				String content = e.attr("href");
				num = Integer.parseInt(content.substring(
						content.indexOf("(") + 1, content.indexOf(")")));
				pages=num;
			}
		}
		String sDesc = doc.getElementsByTag("tbody").get(0)
				.getElementsByTag("tr").get(0).select(".eNo1").get(0).text();
		if (num == 0) {
			num = Integer.parseInt(sDesc.substring(sDesc.lastIndexOf('¹²') + 1,
					sDesc.lastIndexOf('Ìõ')));
			pages = (num + 24) / 25;
		}
		for (int i = 1; i <= pages; i++) {
			if (i > 1) {
				getUrl = String.format(url, categorys.getType(), i,
						categorys.getBoxCategoryId());
				doc = JsoupUtil.GetDocument(getUrl);
			}
			ContainerDO cDo = new ContainerDO();
			cDo.setDoc(doc);
			cDo.setEntity(baseEntity);
			container.Insert(cDo);
			System.out.println("+1");
			// try {
			// Thread.sleep(2000);
			// } catch (InterruptedException e) {
			// e.printStackTrace();
			// }
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

}
