package com.ganggang.Stock;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import com.ganggang.DO.Ookong.OokongPriceDO;
import com.ganggang.Dao.Stock.StockInfoDao;
import com.ganggang.Dao.Stock.StockTransactionDetailDao;
import com.ganggang.Stock.Entity.StockInfo;
import com.ganggang.Stock.Entity.StockTransactionDetail;
import com.ganggang.Util.JsoupUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GetStockInfo {

	public static void main(String[] args) {
		System.out.println("start");
		// getCurrentInfo();
		// getHistory();
//		GetHistoryThread th = new GetHistoryThread();
//		for (int i = 0; i < 5; i++) {
//			Thread t1 = new Thread(th);
//			t1.start();
//		}
		Document doc=JsoupUtil.GetDocument("http://hq.sinajs.cn/list=sh601003");
		System.out.println(doc);
	}

	public static void getCurrentInfo() {
		String url = "http://vip.stock.finance.sina.com.cn/quotes_service/api/json_v2.php/Market_Center.getHQNodeData?page=%s&num=80&sort=changepercent&asc=0&node=hs_a&symbol=&_s_r_a=page";
		for (int i = 1; i < 34; i++) {
			String ru = String.format(url, i);
			Document doc = JsoupUtil.GetDocument(ru);
			Gson gson = new Gson();
			LinkedList<StockPriceInfo> emp = gson.fromJson(doc.body().text(),
					new TypeToken<LinkedList<StockPriceInfo>>() {
					}.getType());
			for (StockPriceInfo info : emp) {
				StockInfo si = new StockInfo();
				si.setCode(info.code);
				si.setName(info.name);
				si.setNewPrice(Double.parseDouble(info.trade));
				si.setVolume(info.volume);
				StockInfoDao.AddStockInfo(si);
			}
		}
		System.out.println("end");
	}

	public static void getHistory() {
		StockInfo info = StockInfoDao.GetUnSpiderHistoryStock();
		while (info != null) {
			String url = "http://vip.stock.finance.sina.com.cn/corp/go.php/vMS_MarketHistory/stockid/%s.phtml?year=2015&jidu=1";
			String ur = String.format(url, info.getCode());
			Document doc = JsoupUtil.GetDocument(ur);
			Element year = doc.select("select[name=year]").get(0);
			Elements years = year.select("option");
			for (Element y : years) {
				System.out.println(info.getCode()+"_"+y.text());
				String uurl = "http://vip.stock.finance.sina.com.cn/corp/go.php/vMS_MarketHistory/stockid/%s.phtml?year=%s&jidu=%s";
				for (int j = 1; j < 5; j++) {
					String uu = String
							.format(uurl, info.getCode(), y.text(), j);
					doc = JsoupUtil.GetDocument(uu);
					Element tb = doc.getElementById("FundHoldSharesTable");
					if (tb != null) {
						Elements trs = tb.getElementsByTag("tbody").get(0)
								.select("tr");
						for (int i = 1; i < trs.size(); i++) {
							StockTransactionDetail detail = new StockTransactionDetail();
							SimpleDateFormat sdf = new SimpleDateFormat(
									"yyyy-MM-dd");
							try {
								detail.setTransactionDate(sdf.parse(trs.get(i)
										.getElementsByTag("tr").get(0)
										.getElementsByTag("td").get(0).text()));
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							detail.setCode(info.getCode());
							detail.setBeginPrice(Double.parseDouble(trs.get(i)
									.getElementsByTag("tr").get(0)
									.getElementsByTag("td").get(1).text()));
							detail.setEndPrice(Double.parseDouble(trs.get(i)
									.getElementsByTag("tr").get(0)
									.getElementsByTag("td").get(3).text()));
							detail.setHighestPrice(Double.parseDouble(trs
									.get(i).getElementsByTag("tr").get(0)
									.getElementsByTag("td").get(2).text()));
							detail.setLowestPrice(Double.parseDouble(trs.get(i)
									.getElementsByTag("tr").get(0)
									.getElementsByTag("td").get(4).text()));
							detail.setVolume(Long.parseLong(trs.get(i)
									.getElementsByTag("tr").get(0)
									.getElementsByTag("td").get(5).text()));
							detail.setTransactionMoney(Long.parseLong(trs
									.get(i).getElementsByTag("tr").get(0)
									.getElementsByTag("td").get(6).text()));
							StockTransactionDetailDao
									.AddStockTransactionDetail(detail);
						}
					}
					info.setIfGetHistory(1);
				}
			}
			StockInfoDao.UpdateCategory(info);
			info = StockInfoDao.GetUnSpiderHistoryStock();
		}
	}
}

class StockPriceInfo {
	public String symbol;
	public String code;
	public String name;
	public String trade;
	public String pricechange;
	public String changepercent;
	public String buy;
	public String settlement;
	public String open;
	public String high;
	public String low;
	public long volume;
	public long amount;
	public String ticktime;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTrade() {
		return trade;
	}

	public void setTrade(String trade) {
		this.trade = trade;
	}

	public String getPricechange() {
		return pricechange;
	}

	public void setPricechange(String pricechange) {
		this.pricechange = pricechange;
	}

	public String getChangepercent() {
		return changepercent;
	}

	public void setChangepercent(String changepercent) {
		this.changepercent = changepercent;
	}

	public String getBuy() {
		return buy;
	}

	public void setBuy(String buy) {
		this.buy = buy;
	}

	public String getSettlement() {
		return settlement;
	}

	public void setSettlement(String settlement) {
		this.settlement = settlement;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public String getHigh() {
		return high;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	public String getLow() {
		return low;
	}

	public void setLow(String low) {
		this.low = low;
	}

	public long getVolume() {
		return volume;
	}

	public void setVolume(long volume) {
		this.volume = volume;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getTicktime() {
		return ticktime;
	}

	public void setTicktime(String ticktime) {
		this.ticktime = ticktime;
	}
}
