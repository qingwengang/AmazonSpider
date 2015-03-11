package com.ganggang.Thread;

import org.jsoup.nodes.Document;

import com.ganggang.Entity.CamelListUrl;

public class CamelUrl {
	private Document doc;
	private int parentId;
	
	private String amazonId;
	private CamelListUrl camelListUrl;

	public CamelListUrl getCamelListUrl() {
		return camelListUrl;
	}

	public void setCamelListUrl(CamelListUrl camelListUrl) {
		this.camelListUrl = camelListUrl;
	}

	public Document getDoc() {
		return doc;
	}

	public String getAmazonId() {
		return amazonId;
	}

	public void setAmazonId(String amazonId) {
		this.amazonId = amazonId;
	}

	public void setDoc(Document doc) {
		this.doc = doc;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
}
