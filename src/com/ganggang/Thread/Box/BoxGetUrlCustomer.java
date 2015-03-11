package com.ganggang.Thread.Box;

import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.ganggang.Dao.Box.BoxCategoryDao;
import com.ganggang.Dao.Box.BoxProductDao;
import com.ganggang.Proxy.BoxzProxy;
import com.ganggang.Thread.Base.BaseCustomer;
import com.ganggang.Thread.Base.Container;
import com.ganggang.Thread.Base.ContainerDO;

public class BoxGetUrlCustomer extends BaseCustomer {

	public BoxGetUrlCustomer(Container container) {
		super(container);
		List<String> ids=BoxProductDao.GetProductIds();
		container.InitIds(ids);
	}

	@Override
	public void Go(ContainerDO data) {
		System.out.println("customer");
		BoxzProxy.GetUrl(container,data);
	}

}
