package com.ganggang.Thread;

import java.util.List;
import com.ganggang.Proxy.CamelProxy;

public class CamelUrlCustomer implements Runnable {
	private CamelUrlContainer container;

	public CamelUrlContainer getContainer() {
		return container;
	}

	public void setContainer(CamelUrlContainer container) {
		this.container = container;
	}

	public void run() {
		try{
		while (true) {
			List<CamelUrl> camelUrls = container.Get();
			System.out.println("-1");
			if(camelUrls.size()<=0){
				Thread.sleep(10000);
			}
			for (CamelUrl camelUrl : camelUrls) {
				CamelProxy.GetList(camelUrl, container);
			}
		}
		}catch(Exception e){
			System.out.println(e);
		}finally{
		}
	}
}