package com.ganggang.Thread.Box;

import org.jsoup.nodes.Element;

import com.ganggang.Thread.Base.BaseCustomer;
import com.ganggang.Thread.Base.Container;
import com.ganggang.Thread.Base.ContainerDO;

public class BoxPriceHistoryCustomer extends BaseCustomer {

	public BoxPriceHistoryCustomer(Container container) {
		super(container);
	}

	@Override
	public void Go(ContainerDO data) {
		Element chartData=data.getDoc().getElementById("chart_data");
		String priceData=chartData.attr("value");
		System.out.println(priceData);
	}

}
