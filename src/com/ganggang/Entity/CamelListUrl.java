package com.ganggang.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class CamelListUrl{
	private int Id;
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
	public String getAmazonID() {
		return AmazonID;
	}
	public void setAmazonID(String amazonID) {
		AmazonID = amazonID;
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
	public String getImgSrc() {
		return ImgSrc;
	}
	public void setImgSrc(String imgSrc) {
		ImgSrc = imgSrc;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public String getProperty() {
		return Property;
	}
	public void setProperty(String property) {
		Property = property;
	}
	public int getParentID() {
		return ParentID;
	}
	public void setParentID(int parentID) {
		ParentID = parentID;
	}
	private String Name;
	private String Url;
	public String getAmazonComment() {
		return AmazonComment;
	}
	public void setAmazonComment(String amazonComment) {
		AmazonComment = amazonComment;
	}
	public int getAmazonFlag() {
		return AmazonFlag;
	}
	public void setAmazonFlag(int amazonFlag) {
		AmazonFlag = amazonFlag;
	}
	private String AmazonID;
	private int ParentID;
	private int Flag;
	private Date LastUpdateTime;
	private String ImgSrc;
	private String Category;
	private String Property;
	private String AmazonComment;
	private int AmazonFlag;
	private String AmazonPrice;
	private int AmazonPriceFlag;
	private String OokongPrice;
	private int OokongPriceFlag;
	private String CamelPriceData;
	private int CamelPriceFlag;
	private String UnimercPrice;
	private int UnimercPriceFlag;
	private String BasicData;
	private int BasicDataFlag;
	public String getUnimercPrice() {
		return UnimercPrice;
	}
	public String getBasicData() {
		return BasicData;
	}
	public void setBasicData(String basicData) {
		BasicData = basicData;
	}
	public int getBasicDataFlag() {
		return BasicDataFlag;
	}
	public void setBasicDataFlag(int basicDataFlag) {
		BasicDataFlag = basicDataFlag;
	}
	public void setUnimercPrice(String unimercPrice) {
		UnimercPrice = unimercPrice;
	}
	public int getUnimercPriceFlag() {
		return UnimercPriceFlag;
	}
	public void setUnimercPriceFlag(int unimercPriceFlag) {
		UnimercPriceFlag = unimercPriceFlag;
	}
	public String getCamelPriceData() {
		return CamelPriceData;
	}
	public void setCamelPriceData(String camelPriceData) {
		CamelPriceData = camelPriceData;
	}
	public int getCamelPriceFlag() {
		return CamelPriceFlag;
	}
	public void setCamelPriceFlag(int camelPriceFlag) {
		CamelPriceFlag = camelPriceFlag;
	}
	public String getOokongPrice() {
		return OokongPrice;
	}
	public void setOokongPrice(String ookongPrice) {
		OokongPrice = ookongPrice;
	}
	public int getOokongPriceFlag() {
		return OokongPriceFlag;
	}
	public void setOokongPriceFlag(int ookongPriceFlag) {
		OokongPriceFlag = ookongPriceFlag;
	}
	public String getAmazonPrice() {
		return AmazonPrice;
	}
	public void setAmazonPrice(String amazonPrice) {
		AmazonPrice = amazonPrice;
	}
	public int getAmazonPriceFlag() {
		return AmazonPriceFlag;
	}
	public void setAmazonPriceFlag(int amazonPriceFlag) {
		AmazonPriceFlag = amazonPriceFlag;
	}
}
