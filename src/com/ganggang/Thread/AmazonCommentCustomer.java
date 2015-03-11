package com.ganggang.Thread;

import com.ganggang.Proxy.AmazonProxy;

public class AmazonCommentCustomer extends Customer {

	public AmazonCommentCustomer(CamelUrlContainer container) {
		super(container);
	}

	@Override
	void Go(CamelUrl camelUrl) {
		AmazonProxy.GetComments(camelUrl);
	}

}
