package com.ganggang.Thread.Base;

import org.jsoup.nodes.Document;

import com.ganggang.Entity.Base.BaseEntity;

public class ContainerDO {
	private Document doc;
	private BaseEntity entity;
	public ContainerDO() {
	}
	public Document getDoc() {
		return doc;
	}
	public void setDoc(Document doc) {
		this.doc = doc;
	}
	public BaseEntity getEntity() {
		return entity;
	}
	public void setEntity(BaseEntity entity) {
		this.entity = entity;
	}
}
