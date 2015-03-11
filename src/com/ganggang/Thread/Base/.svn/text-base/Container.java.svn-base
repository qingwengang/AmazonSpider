package com.ganggang.Thread.Base;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.ganggang.Thread.CamelUrl;
import com.ganggang.Util.BTree;

public class Container {
	private Queue<ContainerDO> containerdos;
	private BTree amazonIds;

	public Container() {
		containerdos = new LinkedList<ContainerDO>();
	}
	public void InitIds(List<String> ids){
		amazonIds=new BTree();
		for (String s : ids) {
			amazonIds.AddString(s);
		}
		System.out.println(amazonIds.GetContents());
	}
	
	public synchronized boolean AddId(String amazonId) {
		if (amazonIds.Check(amazonId)) {
			System.out.println("ÒÑ´æÔÚ"+amazonId);
			return false;
		}
		amazonIds.AddString(amazonId);
		return true;
	}

	public synchronized void Insert(ContainerDO containerDo) {
		while (containerdos.size() >= 1000) {
			try {
				this.wait();
			} catch (InterruptedException e) {
			}
		}
		containerdos.add(containerDo);
		System.out.println("--------------------"+containerdos.size());
		this.notifyAll();
	}

	public synchronized ContainerDO Get() {
		List<ContainerDO> dos = Get(1);
		if(dos.size()>0)
			return dos.get(0);
		else
			return null;
	}

	public synchronized List<ContainerDO> Get(int num) {
		while (containerdos.size() <= 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
			}
		}
		List<ContainerDO> result = new LinkedList<ContainerDO>();
		try {
			int numAdd = num < containerdos.size() ? num : containerdos.size();
			for (int i = 0; i < numAdd; i++) {
				result.add(containerdos.remove());
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
}
