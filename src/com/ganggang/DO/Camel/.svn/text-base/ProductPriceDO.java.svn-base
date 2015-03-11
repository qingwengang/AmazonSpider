package com.ganggang.DO.Camel;

import java.util.LinkedList;
import java.util.List;

public class ProductPriceDO {
	private List<ProductPriceDetailDO> priceDetails;
	private List<ProductPriceHistory> histories;
	private List<ProductDetailDO> productDetails;
	public List<ProductPriceDetailDO> getDetails() {
		if(priceDetails==null) {priceDetails= new LinkedList<ProductPriceDetailDO>();}
		return priceDetails;
	}
	public void setDetails(List<ProductPriceDetailDO> details) {
		this.priceDetails = details;
	}
	public List<ProductDetailDO> getProductDetails() {
		if(productDetails==null) {
			productDetails=new LinkedList<ProductDetailDO>();
		}
		return productDetails;
	}
	public void setProductDetails(List<ProductDetailDO> productDetails) {
		this.productDetails = productDetails;
	}
	public List<ProductPriceHistory> getHistories() {
		if(histories==null) {histories= new LinkedList<ProductPriceHistory>();}
		return histories;
	}
	public void setHistories(List<ProductPriceHistory> histories) {
		this.histories = histories;
	}
}
