package com.ganggang.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class CamelCategory {
	private int Id;
	private String CategoryName;
	private int ParentId;
	private int Level;
	private int flag;
	private Date UpdateTime;
	public Date getUpdateTime() {
		return UpdateTime;
	}
	public void setUpdateTime(Date updateTime) {
		UpdateTime = updateTime;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	@javax.persistence.Id
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	@Column(name="CategoryName")
	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}
	public int getParentId() {
		return ParentId;
	}
	public void setParentId(int parentId) {
		ParentId = parentId;
	}
	public int getLevel() {
		return Level;
	}
	public void setLevel(int level) {
		this.Level = level;
	}
}
