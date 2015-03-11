package com.ganggang.Thread;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.jsoup.nodes.Document;

import com.ganggang.Proxy.CamelProxy;
import com.ganggang.Util.BTree;

public class CamelUrlContainer {
	private Queue<CamelUrl> camelUrls;
	private BTree amazonIds;

	public CamelUrlContainer() {
		camelUrls = new LinkedList<CamelUrl>();
		amazonIds = new BTree();
		List<String> ls = CamelProxy.GetAmazonId();
		for (String s : ls) {
			amazonIds.AddString(s);
		}
		for (String s : amazonIds.GetContents()) {
			System.out.println(s);
		}
		System.out.println(amazonIds.GetContents().size());
	}

	public synchronized boolean AddAmazonId(String amazonId) {
		if (amazonIds.Check(amazonId))
			return false;
		amazonIds.AddString(amazonId);
		return true;
	}

	public synchronized void Insert(CamelUrl url) {
		while (camelUrls.size() >= 1000) {
			try {
				this.wait();
			} catch (InterruptedException e) {
			}
		}
		camelUrls.add(url);
		this.notifyAll();
	}

	public synchronized List<CamelUrl> Get() {
		while (camelUrls.size() <= 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
			}
		}
		this.notifyAll();
		List<CamelUrl> camelUrlLists = new LinkedList<CamelUrl>();
		try {
			camelUrlLists.add(camelUrls.remove());
			if (camelUrls.size() > 10) {
				for (int i = 0; i < 10; i++) {
					camelUrlLists.add(camelUrls.remove());
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return camelUrlLists;
	}

}
