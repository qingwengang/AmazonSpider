package com.ganggang.Factory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.groovy.GJson;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ganggang.DO.Ookong.OokongPriceDO;
import com.ganggang.Dao.MuluDao;
import com.ganggang.Entity.Mulu;
import com.ganggang.Proxy.CamelProxy;
import com.ganggang.Thread.CamelDeatilProducer;
import com.ganggang.Thread.CamelDetailCustomer;
import com.ganggang.Thread.CamelUrlByCategory;
import com.ganggang.Thread.CamelUrlContainer;
import com.ganggang.Thread.CamelUrlCustomer;
import com.ganggang.Thread.CamelUrlProducer;
import com.ganggang.Util.HibernateUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class CamelFactory {
	public static void main(String[] args) throws IOException{
//		
//		getUrlList();
//		GetCamelDetail();
//		TestJson();
		testookong();
//		TestJsonArray();
	}
	
	public static void getUrl() throws IOException{
//		CamelProxy.getUrl("http://camelcamelcamel.com/products");
	}
	public static void getUrlList(){
		System.out.println("fdsfs");
//		getUrl();
		CamelUrlContainer container=new CamelUrlContainer();
		CamelUrlProducer producer=new CamelUrlProducer();
		CamelUrlCustomer customer=new CamelUrlCustomer();
		producer.setContainer(container);
		customer.setContainer(container);
//		Thread t1=new Thread(producer);
//		t1.start();
//		Thread t2=new Thread(producer);
//		t2.start();
//		Thread t3=new Thread(producer);
//		t3.start();
//		Thread t4=new Thread(producer);
//		t4.start();
		CamelUrlByCategory camelCa=new CamelUrlByCategory();
		camelCa.setContainer(container);
		Thread t8=new Thread(camelCa);
		t8.start();
		Thread t9=new Thread(camelCa);
		t9.start();
		Thread t10=new Thread(camelCa);
		t10.start();
		Thread t5= new Thread(customer);
		t5.start();
		Thread t6= new Thread(customer);
		t6.start();
		Thread t7= new Thread(customer);
		t7.start();
	}
	public static void GetCamelDetail(){
		CamelUrlContainer container=new CamelUrlContainer();
		CamelDeatilProducer producer=new CamelDeatilProducer();
		producer.setContainer(container);
		CamelDetailCustomer customer=new CamelDetailCustomer();
		customer.setContainer(container);
		Thread t1=new Thread(producer);
		t1.start();
		Thread t2=new Thread(customer);
		t2.start();
	}
	public static void TestJson(){
		Map<String,String> ma=new HashMap<String, String>();
		ma.put("fds","ganggang");
		ma.put("haha", "hehe");
		A a=new A();
        JSONArray jsonArray = JSONArray.fromObject( a );  
        System.out.println( jsonArray );  
        String res="{ \"amazon\" : [[[1338599659000,229],[1338606521000,229],[1338675017000,229],[1338787298000,229],[1338963412000,229],[1338988763000,229],[1339116294000,229],[1339128740000,229],[1339212093000,229],[1339251906000,229],[1339394935000,229],[1339457187000,229],[1339492561000,229],[1339578693000,229],[1339603483000,229],[1339704931000,229],[1339729665000,229],[1339794782000,229],[1339903228000,229],[1340051221000,229],[1340075467000,229],[1340137664000,229],[1340159089000,229],[1415161249000,229]]], \"is_amazon\" : [[1]],\"third\" : [[[1338599659000,229],[1338606521000,229],[1338675017000,229],[1338787298000,229],[1338963412000,229],[1338988763000,229],[1339116294000,229],[1339128740000,229],[1339212093000,229],[1339251906000,229],[1339394935000,229],[1339457187000,229],[1339492561000,229],[1339578693000,229],[1339603483000,229],[1339704931000,229],[1339729665000,229],[1339794782000,229],[1339903228000,229],[1340051221000,229],[1340075467000,229],[1340137664000,229],[1340159089000,229],[1415161249000,229]]], \"is_third\" : [[1]],\"used\" : [[[1338599659000,149.94],[1338606521000,149.95],[1338675017000,159.99],[1338787298000,163.99],[1338963412000,162.44],[1338988763000,160.94],[1339116294000,159.36],[1339128740000,159.36],[1339212093000,155.34],[1339251906000,153.83],[1339394935000,153.83],[1339457187000,140],[1339492561000,153.83],[1339578693000,164.94],[1339603483000,153.83],[1339704931000,153.82],[1339729665000,163.44],[1339794782000,164.94],[1339903228000,164.94],[1340051221000,154.33],[1340075467000,125],[1340137664000,110],[1340159089000,125],[1415161249000,125]]], \"is_used\" : [[1]],\"refurb\" : [[[1338599659000,192],[1338606521000,192],[1338675017000,192],[1338787298000,189.49],[1338963412000,189.49],[1338988763000,189.49],[1339116294000,188.98],[1339128740000,189.49],[1339212093000,192],[1339251906000,192],[1339394935000,194.99],[1339457187000,194.99],[1339492561000,189.49],[1339578693000,189.49],[1339603483000,189.49],[1339704931000,189.49],[1339729665000,189.49],[1339794782000,189.49],[1339903228000,194.99],[1340051221000,194.99],[1340075467000,189.49],[1340137664000,189.49],[1340159089000,194.99],[1415161249000,194.99]]], \"is_refurb\" : [[1]]}";
        res=res.replaceAll("\\[\\[", "\\[").replaceAll("\\]\\]", "\\]");
        System.out.println(res);
        JSONObject obj=JSONObject.fromObject(res);
        A emp=(A) JSONObject.toBean(obj,A.class);
        for(int i = 0; i <emp.getAmazon().size(); i++){
            
            JSONArray ja1 = emp.getAmazon().getJSONArray(i);//获取ja中的第一个元素，因为这个元素
            //也是jsonArray,所以可以再进一步解析
            Long d1 = ja1.getLong(0);//jsonArray中没有getFloat()这个方法
            //，自行转型就可以了
            double d2 = ja1.getDouble(1);//
            System.out.println(d1);
            System.out.println(d2);
            Gson gson = new Gson();
        }
        System.out.println(emp.getAmazon().size());
	}
	
	public static void testookong(){
		Gson gson = new Gson();
		String res="{\"ASIN\":\"B001IKKIVM\",\"Title\":\"Brother PC-Connectable Label Maker (PT-1230PC)\",\"SmallImageUrl\":\"httrGRL._SL75_.jpg\",\"DetailPageURL\":\"httrKKIVM\",\"Catalog\":\"Office Product\",\"is_followed\":\"\",\"Prices\":[[1399968129000,25.25],[1405926680000,29.99],[1406087054000,37.89],[1410568285000,39.49],[1413649168000,40.31],[1415018100000,29.99],[1415520129000,29.99]],\"ThirdPartyNewPrices\":[[1399968129000,null],[1415520129000,null]],\"FormattedPrice\":\"$29.99\",\"FollowersLink\":\"rB001IKKIVM\",\"FollowersCount\":\"9\",\"ThirdPartyNewPrice\":\"$31.50\"}";
		OokongPriceDO priceDo=gson.fromJson(res,new TypeToken<OokongPriceDO>(){}.getType());
		System.out.println(priceDo.getPrices());
//		System.out.println(priceDo.getth());
	}
	public static void TestJsonArray(){
		 Map<String, String> map = new LinkedHashMap<String, String>();
	        map.put("key1", "value1");
	        map.put("key2", "value2");
	        map.put("key3", "value3");
	        Gson gson = new Gson();

	        // Serialize.
	        String json = gson.toJson(map);
	        System.out.println(json); // {"key1":"value1","key2":"value2","key3":"value3"}
	        
	        Map<String, String> map2 = gson.fromJson(json, new TypeToken<Map<String, String>>() {}.getType());
	        System.out.println(map2); // {key1=value1, key2=value2, key3=value3}
	}
	
}
