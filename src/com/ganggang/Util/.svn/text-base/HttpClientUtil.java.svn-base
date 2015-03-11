package com.ganggang.Util;

import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class HttpClientUtil {
	public static void main(String[] args){
		
		System.out.println( GetHtml("http://www.baidu.com","119.6.136.126",80));
	}
	public static String GetHtml(String url){
		String html="";
		HttpClient httpCLient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet(url);  
        try  
        {  
            HttpResponse response = httpCLient.execute(httpget); 
            Header[] heads = response.getAllHeaders(); 
            HttpEntity entity = response.getEntity(); 
            html= EntityUtils.toString(entity);
        } catch (ClientProtocolException e){  
            e.printStackTrace();  
        } catch (IOException e){  
            e.printStackTrace();  
        }finally{  
            httpCLient.getConnectionManager().shutdown();  
        }  
        return html;
	}
	public static String GetHtml(String url,String proxyIP,int proxyPort){
		String html="";
		HttpClient httpCLient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet(url);  
        HttpHost proxy = new HttpHost(proxyIP,proxyPort);  
        httpCLient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);
        try  
        {  
            HttpResponse response = httpCLient.execute(httpget); 
            Header[] heads = response.getAllHeaders(); 
            HttpEntity entity = response.getEntity(); 
            html= EntityUtils.toString(entity);
        } catch (ClientProtocolException e){  
            e.printStackTrace();  
        } catch (IOException e){  
            e.printStackTrace();  
        }finally{  
            httpCLient.getConnectionManager().shutdown();  
        }  
        return html;
	}
	
	
}
