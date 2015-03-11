package com.ganggang.Entity.Box;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.ganggang.Entity.Base.BaseEntity;

@Entity
public class BoxProduct extends BaseEntity {
	private int Id;
	private String Name;
	private String OutId;
	private String CategoryId;
	private String CurrentPrice;
	private String Type;
	private String DetailInfo;
	private int DetailInfoFlag;
	private String PriceHistoryInfo;
	private int PriceHistoryFlag;
	
	public BoxProduct() {
	}
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	public String getOutId() {
		return OutId;
	}
	public void setOutId(String outId) {
		OutId = outId;
	}
	public String getCategoryId() {
		return CategoryId;
	}
	public void setCategoryId(String categoryId) {
		CategoryId = categoryId;
	}
	public String getCurrentPrice() {
		return CurrentPrice;
	}
	public void setCurrentPrice(String currentPrice) {
		CurrentPrice = currentPrice;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getDetailInfo() {
		return DetailInfo;
	}
	public void setDetailInfo(String detailInfo) {
		DetailInfo = detailInfo;
	}
	public int getDetailInfoFlag() {
		return DetailInfoFlag;
	}
	public void setDetailInfoFlag(int detailInfoFlag) {
		DetailInfoFlag = detailInfoFlag;
	}
	public String getPriceHistoryInfo() {
		return PriceHistoryInfo;
	}
	public void setPriceHistoryInfo(String priceHistoryInfo) {
		PriceHistoryInfo = priceHistoryInfo;
	}
	public int getPriceHistoryFlag() {
		return PriceHistoryFlag;
	}
	public void setPriceHistoryFlag(int priceHistoryFlag) {
		PriceHistoryFlag = priceHistoryFlag;
	}
	

}
