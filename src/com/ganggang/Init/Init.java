package com.ganggang.Init;

import java.io.IOException;

import com.ganggang.Proxy.AmazonProxy;
import com.ganggang.Proxy.BoxzProxy;
import com.ganggang.Proxy.CamelProxy;
import com.ganggang.Thread.AmazonCommentCustomer;
import com.ganggang.Thread.AmazonCommentProducer;
import com.ganggang.Thread.CamelDeatilProducer;
import com.ganggang.Thread.CamelDetailCustomer;
import com.ganggang.Thread.CamelUrlContainer;
import com.ganggang.Thread.CamelUrlCustomer;
import com.ganggang.Thread.CamelUrlProducer;
import com.ganggang.Thread.OokongPriceCustomer;
import com.ganggang.Thread.OokongPriceProducer;
import com.ganggang.Thread.UnimercPriceCustomer;
import com.ganggang.Thread.UnimercPriceProducer;
import com.ganggang.Thread.Base.Container;
import com.ganggang.Thread.Box.BoxDetailInfoCustomer;
import com.ganggang.Thread.Box.BoxDetailInfoProducer;
import com.ganggang.Thread.Box.BoxGetUrlCustomer;
import com.ganggang.Thread.Box.BoxGetUrlProducer;
import com.ganggang.Thread.Box.BoxPriceHistoryCustomer;
import com.ganggang.Thread.Box.BoxPriceHistoryProducer;

public class Init {

	public static void main(String[] args) {
		// ³õÊ¼»¯Ä¿Â¼
		// try {
		// CamelProxy.getUrl();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// GetUrlList();
		// try {
		// Thread.sleep(30000);
		// } catch (InterruptedException e) {
		// System.out.println(e);
		// }
		// GetCamelDetail();
		// try {
		// Thread.sleep(30000);
		// } catch (InterruptedException e) {
		// System.out.println(e);
		// }
		// GetOokongData();
		// try {
		// Thread.sleep(30000);
		// } catch (InterruptedException e) {
		// System.out.println(e);
		// }
		// GetUnimercPrice();
		// try {
		// Thread.sleep(30000);
		// } catch (InterruptedException e) {
		// System.out.println(e);
		// }
//		 GetComments();
//		 GetBoxCategory();
//		GetBox();
//		GetDetail();
		GetPriceData();

	}

	private static void GetUrlList() {
		CamelUrlContainer container = new CamelUrlContainer();
		CamelUrlProducer producer = new CamelUrlProducer();
		CamelUrlCustomer customer = new CamelUrlCustomer();
		producer.setContainer(container);
		customer.setContainer(container);
		for (int i = 0; i < 3; i++) {
			Thread t1 = new Thread(producer);
			t1.start();
		}
		for (int i = 0; i < 2; i++) {
			Thread t7 = new Thread(customer);
			t7.start();
		}
	}

	private static void GetCamelDetail() {
		CamelUrlContainer container = new CamelUrlContainer();
		CamelDeatilProducer producer = new CamelDeatilProducer();
		CamelDetailCustomer customer = new CamelDetailCustomer();
		producer.setContainer(container);
		customer.setContainer(container);
		for (int i = 0; i < 10; i++) {
			Thread t1 = new Thread(producer);
			t1.start();
		}
		for (int i = 0; i < 10; i++) {
			Thread t7 = new Thread(customer);
			t7.start();
		}
	}

	private static void GetOokongData() {
		CamelUrlContainer container = new CamelUrlContainer();
		OokongPriceProducer priceProducer = new OokongPriceProducer();
		OokongPriceCustomer priceCustomer = new OokongPriceCustomer();
		priceProducer.setContainer(container);
		priceCustomer.setContainer(container);
		for (int i = 0; i < 10; i++) {
			Thread t1 = new Thread(priceProducer);
			t1.start();
		}
		for (int i = 0; i < 5; i++) {
			Thread t2 = new Thread(priceCustomer);
			t2.start();
		}
	}

	private static void GetUnimercPrice() {
		CamelUrlContainer container = new CamelUrlContainer();
		UnimercPriceProducer priceProducer = new UnimercPriceProducer();
		UnimercPriceCustomer priceCustomer = new UnimercPriceCustomer();
		priceProducer.setContainer(container);
		priceCustomer.setContainer(container);
		for (int i = 0; i < 10; i++) {
			Thread t1 = new Thread(priceProducer);
			t1.start();
		}
		for (int i = 0; i < 10; i++) {
			Thread t2 = new Thread(priceCustomer);
			t2.start();
		}
	}

	private static void GetComments() {
		CamelUrlContainer container = new CamelUrlContainer();
		AmazonCommentProducer commentProducer = new AmazonCommentProducer(
				container);
		AmazonCommentCustomer commentCustomer = new AmazonCommentCustomer(
				container);
		for (int i = 0; i < 10; i++) {
			Thread t1 = new Thread(commentProducer);
			t1.start();
		}
		for (int i = 0; i < 10; i++) {
			Thread t2 = new Thread(commentCustomer);
			t2.start();
		}
	}

	private static void GetBoxCategory() {
		 BoxzProxy.GetBoxCategory("360buy", "737");
		 BoxzProxy.GetBoxCategory("360buy", "670");
		 BoxzProxy.GetBoxCategory("360buy", "9987");
		 BoxzProxy.GetBoxCategory("360buy", "652");
		// BoxzProxy.GetBoxCategory("360buy", 1316);
		// BoxzProxy.GetBoxCategory("360buy", 5025);
		// BoxzProxy.GetBoxCategory("360buy", 1319);
		// BoxzProxy.GetBoxCategory("360buy", 1320);
		// BoxzProxy.GetBoxCategory("360buy", 6196);
		// BoxzProxy.GetBoxCategory("360buy", 1315);
		// BoxzProxy.GetBoxCategory("360buy", 11729);
		// BoxzProxy.GetBoxCategory("360buy", 1672);
		// BoxzProxy.GetBoxCategory("360buy", 6144);
		// BoxzProxy.GetBoxCategory("360buy", 1318);
		// BoxzProxy.GetBoxCategory("360buy", 6728);
		// BoxzProxy.GetBoxCategory("360buy", 6233);
		// BoxzProxy.GetBoxCategory("360buy", 1620);
		// BoxzProxy.GetBoxCategory("360buy", 6994);
		// BoxzProxy.GetBoxCategory("360buy", 9847);
		// BoxzProxy.GetBoxCategory("360buy", 9855);

		 BoxzProxy.GetBoxCategory("icson", "a1");
		 BoxzProxy.GetBoxCategory("icson", "a2");
		 BoxzProxy.GetBoxCategory("icson", "a3");
		// BoxzProxy.GetBoxCategory("icson", "a4");
		// BoxzProxy.GetBoxCategory("icson", "a5");
		// BoxzProxy.GetBoxCategory("icson", "a6");
		// BoxzProxy.GetBoxCategory("icson", "a7");
		// BoxzProxy.GetBoxCategory("icson", "a8");
		// BoxzProxy.GetBoxCategory("icson", "a9");
		// BoxzProxy.GetBoxCategory("icson", "a10");

		BoxzProxy.GetBoxCategory("yihaodian", "21392");
		BoxzProxy.GetBoxCategory("yihaodian", "21266");
		BoxzProxy.GetBoxCategory("yihaodian", "21306");
//		BoxzProxy.GetBoxCategory("yihaodian", "950340");
//		BoxzProxy.GetBoxCategory("yihaodian", "8644");
//		BoxzProxy.GetBoxCategory("yihaodian", "5135");
//		BoxzProxy.GetBoxCategory("yihaodian", "123");
//		BoxzProxy.GetBoxCategory("yihaodian", "22906");
//		BoxzProxy.GetBoxCategory("yihaodian", "5009");
//		BoxzProxy.GetBoxCategory("yihaodian", "5117");
//		BoxzProxy.GetBoxCategory("yihaodian", "5134");
//		BoxzProxy.GetBoxCategory("yihaodian", "34140");
//		BoxzProxy.GetBoxCategory("yihaodian", "32258");
//		BoxzProxy.GetBoxCategory("yihaodian", "5342");
		
		BoxzProxy.GetBoxCategory("amazon", "664978051");
		BoxzProxy.GetBoxCategory("amazon", "755653051");
		BoxzProxy.GetBoxCategory("amazon", "760233051");
		BoxzProxy.GetBoxCategory("amazon", "888465051");
		
		
		BoxzProxy.GetBoxCategory("suning", "20089");
		BoxzProxy.GetBoxCategory("suning", "157122");
		BoxzProxy.GetBoxCategory("suning", "20268");
		BoxzProxy.GetBoxCategory("suning", "20358");
		
		BoxzProxy.GetBoxCategory("gome", "l2");
		BoxzProxy.GetBoxCategory("gome", "l3");
		BoxzProxy.GetBoxCategory("gome", "l4");
		BoxzProxy.GetBoxCategory("gome", "l5");
	}

	private static void GetBox() {
		Container container = new Container();
		BoxGetUrlProducer prod = new BoxGetUrlProducer(container);
		BoxGetUrlCustomer customer = new BoxGetUrlCustomer(container);
		for (int i = 0; i < 1; i++) {
			Thread t = new Thread(prod);
			Thread tt = new Thread(customer);
			Thread ttt = new Thread(customer);
			t.start();
			tt.start();
			ttt.start();
		}
	}
	private static void GetDetail() {
		Container container = new Container();
		BoxDetailInfoProducer prod = new BoxDetailInfoProducer(container);
		BoxDetailInfoCustomer customer = new BoxDetailInfoCustomer(container);
		for (int i = 0; i < 10; i++) {
			Thread t = new Thread(prod);
			Thread tt = new Thread(customer);
			Thread ttt = new Thread(customer);
			t.start();
			tt.start();
			ttt.start();
		}
	}
	private static void GetPriceData(){
		Container container = new Container();
		BoxPriceHistoryProducer prod = new BoxPriceHistoryProducer(container);
		BoxPriceHistoryCustomer customer = new BoxPriceHistoryCustomer(container);
		for (int i = 0; i < 10; i++) {
			Thread t = new Thread(prod);
			Thread tt = new Thread(customer);
			Thread ttt = new Thread(customer);
			t.start();
			tt.start();
			ttt.start();
		}
	}
}
