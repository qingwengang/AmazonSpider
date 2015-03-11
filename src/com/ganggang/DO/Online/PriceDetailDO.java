package com.ganggang.DO.Online;

public class PriceDetailDO implements Comparable {
	public PriceDetailDO(long timeStamp,double price){
		setTimeStamp(timeStamp);
		setPrice(price);
	}
	
	private Long timeStamp;
	private Double price;
	
	public Long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public int compareTo(Object o) {
		PriceDetailDO price=(PriceDetailDO)o;
		return this.getTimeStamp().compareTo(price.getTimeStamp());
	}
	
}
