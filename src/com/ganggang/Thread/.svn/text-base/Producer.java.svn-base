package com.ganggang.Thread;

import java.util.List;

import com.ganggang.Entity.CamelListUrl;

public abstract class Producer implements Runnable {
	private CamelUrlContainer container;
	public Producer(CamelUrlContainer container){
		this.container=container;
	}
	private synchronized List<CamelListUrl> GetUnSpinerCamelListUrl(){
		return GetData();
	}
	@Override
	public void run() {
		List<CamelListUrl> listUrls=GetUnSpinerCamelListUrl();
		while(true){
			if(listUrls.size()<=0){
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else{
				for (CamelListUrl camelListUrl : listUrls) {
					CamelUrl camelUrl=Go(camelListUrl);
					if(camelUrl!=null) container.Insert(camelUrl);
				}
			}
			listUrls=GetUnSpinerCamelListUrl();
		}
	}
	
	abstract public List<CamelListUrl> GetData();
	abstract public CamelUrl Go(CamelListUrl camelUrl);
}
