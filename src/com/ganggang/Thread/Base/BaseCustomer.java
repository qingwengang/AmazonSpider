package com.ganggang.Thread.Base;

import java.util.List;

import com.ganggang.Util.LogHelper;

public abstract class BaseCustomer implements Runnable {
	public Container container;

	public BaseCustomer(Container container) {
		this.container = container;
	}

	@Override
	public void run() {
		while (true) {
			List<ContainerDO> datas = container.Get(1);
			if (datas.size() <= 0) {
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				for (ContainerDO data : datas) {
					try {
						Go(data);
					} catch (Exception ex) {
						LogHelper.AddLog("BaseCustomer", ex.getMessage());
					}
				}
			}
		}
	}

	abstract public void Go(ContainerDO data);
}
