package com.ganggang.DO.Box;

import java.util.LinkedList;
import java.util.List;

import net.sf.json.JSONObject;

import com.ganggang.DO.Unimerc.UnimercPriceDO;

public class BoxCategory {
	private String id;
	private String name;
	private List<BoxCategoryDO> children=new LinkedList<BoxCategoryDO>();
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<BoxCategoryDO> getChildren() {
		return children;
	}
	public void setChildren(List<BoxCategoryDO> children) {
		this.children = children;
	}
	
}
