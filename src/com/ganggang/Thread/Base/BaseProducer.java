package com.ganggang.Thread.Base;

import java.util.List;

import com.ganggang.Entity.CamelListUrl;
import com.ganggang.Entity.Base.BaseEntity;
import com.ganggang.Thread.CamelUrl;
import com.ganggang.Thread.CamelUrlContainer;

public abstract class BaseProducer implements Runnable {
	public Container container;

	public BaseProducer(Container container) {
		this.container = container;
	}

	private synchronized List<? extends BaseEntity> GetUnSpiderData() {
		return GetData();
	}

	@Override
	public void run() {
		List<? extends BaseEntity> datas = GetUnSpiderData();
		while (true) {
			if (datas.size() <= 0) {
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				for (BaseEntity baseEntity : datas) {
					try{
					ContainerDO cDo=Go(baseEntity);
					if(cDo!=null){
						container.Insert(cDo);
					}
					}catch(Exception ex){
						System.out.println(ex);
					}
				}
			}
			datas = GetUnSpiderData();
		}
	}

	abstract public List<? extends BaseEntity> GetData();

	abstract public ContainerDO Go(BaseEntity baseEntity);
}
