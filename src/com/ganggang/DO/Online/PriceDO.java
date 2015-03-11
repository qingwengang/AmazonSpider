package com.ganggang.DO.Online;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class PriceDO {
	private List<PriceDetailDO> amazonPrices;
	private List<PriceDetailDO> thirdPartyPrice;
	public List<PriceDetailDO> getAmazonPrices() {
		if(amazonPrices==null){
			amazonPrices=new LinkedList<PriceDetailDO>();
		}
		return amazonPrices;
	}
	public void setAmazonPrices(List<PriceDetailDO> prices) {
		this.amazonPrices = prices;
	}
	public List<PriceDetailDO> getThirdPartyPrice() {
		if(thirdPartyPrice==null){
			thirdPartyPrice=new LinkedList<PriceDetailDO>();
		}
		return thirdPartyPrice;
	}
	public void setThirdPartyPrice(List<PriceDetailDO> thirdPartyPrice) {
		this.thirdPartyPrice = thirdPartyPrice;
	}
}

