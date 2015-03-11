package com.ganggang.Entity.Ebay;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class EbayDetail {
	private int Id;
	private String Name;
	private String Url;
	private String CommentUrl;
	private String Comments;
	private int Flag;
	private String EbayID;
	private int CommentUrlFlag;
	private int CommentFlag;
	private int CommentCount;
	private String UserID;
	private String IID;
	
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getIID() {
		return IID;
	}
	public void setIID(String iID) {
		IID = iID;
	}
	public int getCommentCount() {
		return CommentCount;
	}
	public void setCommentCount(int commentCount) {
		CommentCount = commentCount;
	}
	public int getCommentUrlFlag() {
		return CommentUrlFlag;
	}
	public void setCommentUrlFlag(int commentUrlFlag) {
		CommentUrlFlag = commentUrlFlag;
	}
	public int getCommentFlag() {
		return CommentFlag;
	}
	public void setCommentFlag(int commentFlag) {
		CommentFlag = commentFlag;
	}
	public String getEbayID() {
		return EbayID;
	}
	public void setEbayID(String ebayID) {
		EbayID = ebayID;
	}
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	public String getCommentUrl() {
		return CommentUrl;
	}
	public void setCommentUrl(String commentUrl) {
		CommentUrl = commentUrl;
	}
	public String getComments() {
		return Comments;
	}
	public void setComments(String comments) {
		Comments = comments;
	}
	public int getFlag() {
		return Flag;
	}
	public void setFlag(int flag) {
		Flag = flag;
	}
	
}
