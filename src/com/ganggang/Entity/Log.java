package com.ganggang.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Log {
	public Log(String Type, String Content) {
		this.Type = Type;
		this.Content = Content;
		AddTime=new Date();
	}

	private int Id;

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String Type;
	public String Content;
	public Date AddTime;

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public Date getAddTime() {
		return AddTime;
	}

	public void setAddTime(Date addTime) {
		AddTime = addTime;
	}

}
