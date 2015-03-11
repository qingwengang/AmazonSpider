package com.ganggang.Proxy;

import com.ganggang.Util.HttpClientUtil;

public class ZingsaleProxy {
	private static String priceUrl="http://zingsale.com/app/prices/list2/?ProductId=1933878223&StartDate=2013-9-30&EndDate=2014-9-30&Type=New";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GetPriceData("fds");
	}
	public static void GetPriceData(String id){
		String html=HttpClientUtil.GetHtml(priceUrl);
		System.out.println(html);
	}
}
