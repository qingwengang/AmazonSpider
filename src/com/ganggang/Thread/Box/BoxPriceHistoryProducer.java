package com.ganggang.Thread.Box;

import java.util.List;

import org.jsoup.nodes.Document;

import com.ganggang.Dao.Box.BoxProductDao;
import com.ganggang.Entity.Base.BaseEntity;
import com.ganggang.Entity.Box.BoxProduct;
import com.ganggang.Thread.Base.BaseProducer;
import com.ganggang.Thread.Base.Container;
import com.ganggang.Thread.Base.ContainerDO;
import com.ganggang.Util.JsoupUtil;

public class BoxPriceHistoryProducer extends BaseProducer {
	private static String priceUrl="http://www.boxz.com/products/%s-%s.shtml";
	public BoxPriceHistoryProducer(Container container) {
		super(container);
	}

	@Override
	public List<? extends BaseEntity> GetData() {
		return BoxProductDao.GetUnSipderPriceHistory();
	}

	@Override
	public ContainerDO Go(BaseEntity baseEntity) {
		ContainerDO containerDo=new ContainerDO();
		BoxProduct product=(BoxProduct)baseEntity;
		Document doc=JsoupUtil.GetDocument(String.format(priceUrl, product.getType(),product.getOutId()));
		containerDo.setDoc(doc);
		return containerDo;
	}

}
