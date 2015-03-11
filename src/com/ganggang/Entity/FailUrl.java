package com.ganggang.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
@Entity
public class FailUrl {
	private int Id;
	private String Type;
	private String Url;
	private int Flag;
	private int OutId;
	private Date ChangeTime;
	public FailUrl(String type,String url){
		this.Type=type;
		this.Url=url;
		this.Flag=0;
		this.ChangeTime=new Date();
	}
	public FailUrl(String type,String url,int outId){
		this.Type=type;
		this.Url=url;
		this.Flag=0;
		this.OutId=outId;
		this.ChangeTime=new Date();
	}
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
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
	public int getOutId() {
		return OutId;
	}

	public void setOutId(int outId) {
		OutId = outId;
	}

	public Date getChangeTime() {
		return ChangeTime;
	}
	public void setChangeTime(Date changeTime) {
		ChangeTime = changeTime;
	}
}
