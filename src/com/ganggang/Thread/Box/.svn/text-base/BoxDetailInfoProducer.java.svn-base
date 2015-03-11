package com.ganggang.Thread.Box;

import java.util.List;

import org.jsoup.nodes.Document;

import com.ganggang.Dao.Box.BoxProductDao;
import com.ganggang.Entity.Base.BaseEntity;
import com.ganggang.Entity.Box.BoxProduct;
import com.ganggang.Proxy.JDProxy;
import com.ganggang.Thread.Base.BaseProducer;
import com.ganggang.Thread.Base.Container;
import com.ganggang.Thread.Base.ContainerDO;

public class BoxDetailInfoProducer extends BaseProducer {

	public BoxDetailInfoProducer(Container container) {
		super(container);
	}

	@Override
	public List<? extends BaseEntity> GetData() {
		return BoxProductDao.GetUnSipderDetailInfo();
	}

	@Override
	public ContainerDO Go(BaseEntity baseEntity) {
		ContainerDO containDo=new ContainerDO();
		BoxProduct product=(BoxProduct)baseEntity;
		Document doc =JDProxy.GetDetailDocument(product);
		containDo.setEntity(baseEntity);
		containDo.setDoc(doc);
		return containDo;
	}

}
