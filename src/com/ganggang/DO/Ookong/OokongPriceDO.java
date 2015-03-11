package com.ganggang.DO.Ookong;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import net.sf.json.JSONArray;

public class OokongPriceDO {
	private static final int Long = 0;
	public String ASIN;
	public String Title;
	public String SmallImageUrl;
	public String DetailPageURL;
	public String Catalog;
	public String is_followed;
	public String FormattedPrice;
	public String FollowersLink;
	public String FollowersCount;
	public String ThirdPartyNewPrice;
	public Map<Long,Double> Prices=new LinkedHashMap<Long,Double>();
	public Map<Long,Double> ThirdPartyNewPrices=new LinkedHashMap<Long,Double>();
	
	public Map<Long, Double> getPrices() {
		return Prices;
	}

	public void setPrices(Map<Long, Double> prices) {
		Prices = prices;
	}

	public Map<Long, Double> getThirdPartyNewPrices() {
		return ThirdPartyNewPrices;
	}

	public void setThirdPartyNewPrices(Map<Long, Double> thirdPartyNewPrices) {
		ThirdPartyNewPrices = thirdPartyNewPrices;
	}


	public String getASIN() {
		return ASIN;
	}
	
	public void setASIN(String aSIN) {
		ASIN = aSIN;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getSmallImageUrl() {
		return SmallImageUrl;
	}
	public void setSmallImageUrl(String smallImageUrl) {
		SmallImageUrl = smallImageUrl;
	}
	public String getDetailPageURL() {
		return DetailPageURL;
	}
	public void setDetailPageURL(String detailPageURL) {
		DetailPageURL = detailPageURL;
	}
	public String getCatalog() {
		return Catalog;
	}
	public void setCatalog(String catalog) {
		Catalog = catalog;
	}
	public String getIs_followed() {
		return is_followed;
	}
	public void setIs_followed(String is_followed) {
		this.is_followed = is_followed;
	}
	public String getFormattedPrice() {
		return FormattedPrice;
	}
	public void setFormattedPrice(String formattedPrice) {
		FormattedPrice = formattedPrice;
	}
	public String getFollowersLink() {
		return FollowersLink;
	}
	public void setFollowersLink(String followersLink) {
		FollowersLink = followersLink;
	}
	public String getFollowersCount() {
		return FollowersCount;
	}
	public void setFollowersCount(String followersCount) {
		FollowersCount = followersCount;
	}
	public String getThirdPartyNewPrice() {
		return ThirdPartyNewPrice;
	}
	public void setThirdPartyNewPrice(String thirdPartyNewPrice) {
		ThirdPartyNewPrice = thirdPartyNewPrice;
	}
	
	
}
