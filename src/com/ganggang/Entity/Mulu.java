package com.ganggang.Entity;

import java.util.Date;

import javax.persistence.Entity;


@Entity
public class Mulu {
	private int Id;
	private String Name;
	private String Url;
	private int Flag;
	private int TypeId;
	private Date LastUpdateTime;
	@javax.persistence.Id
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	
	public int getFlag() {
		return Flag;
	}
	public void setFlag(int flag) {
		Flag = flag;
	}
	public Date getLastUpdateTime() {
		return LastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		LastUpdateTime = lastUpdateTime;
	}
	public int getTypeId() {
		return TypeId;
	}
	public void setTypeId(int typeId) {
		TypeId = typeId;
	}
}