package com.ganggang.Thread.Box;

import com.ganggang.Proxy.JDProxy;
import com.ganggang.Thread.Base.BaseCustomer;
import com.ganggang.Thread.Base.Container;
import com.ganggang.Thread.Base.ContainerDO;

public class BoxDetailInfoCustomer extends BaseCustomer {

	public BoxDetailInfoCustomer(Container container) {
		super(container);
	}

	@Override
	public void Go(ContainerDO data) {
		JDProxy.GetDetailDocument(data);
	}

}
