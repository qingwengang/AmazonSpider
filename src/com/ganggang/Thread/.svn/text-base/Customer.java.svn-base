package com.ganggang.Thread;

import java.awt.Container;
import java.util.List;

import com.ganggang.Proxy.CamelProxy;

public abstract class Customer implements Runnable {
	private CamelUrlContainer container;

	public Customer(CamelUrlContainer container) {
		this.container = container;
	}

	@Override
	public void run() {
		while (true) {
			List<CamelUrl> camelUrls = container.Get();
			if (camelUrls.size() <= 0) {
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					System.out.println(e);
				}
			} else {
				for(CamelUrl camelUrl : camelUrls){
					Go(camelUrl);
				}
			}
		}
	}
	abstract void Go(CamelUrl camelUrl);
}
