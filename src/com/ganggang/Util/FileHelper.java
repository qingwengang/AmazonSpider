package com.ganggang.Util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class FileHelper {
	
	public static void main(String[] args) throws IOException{
//		WriteEbayComments("fds", "fdsf", "fdslfjlsjjfdslfjlsfjdl费德勒的房间里是附近 ");
		String result=ReadEbayComments("fds", "fdsf")+"a";
		System.out.println(result);
		System.out.println("fds");
	}
	public static void WriteEbayComments(String userId,String iid,String content) throws IOException{
		File mulu=new File("D:/AmazonData/Ebay/Comments/"+userId);
		if(!mulu.exists())mulu.mkdir();
		File file=new File("D:/AmazonData/Ebay/Comments/"+userId+"/"+iid+".txt");
        if(!file.exists())
            file.createNewFile();
        FileOutputStream out=new FileOutputStream(file,true); 
        out.write(content.getBytes("utf-8"));
        out.close();
        
    }
	public static String ReadEbayComments(String userId,String iid) throws IOException{
		String  file="D:/AmazonData/Ebay/Comments/"+userId+"/"+iid+".txt";
		return BufferedReaderDemo(file);
	}
	public static String BufferedReaderDemo(String path) throws IOException{
		File file = new File(path);  
		StringBuilder sb=new StringBuilder();
		try {  
			InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
			BufferedReader reader = new BufferedReader(isr);  
			String line = reader.readLine();  
		    while(line!=null){
		    	sb.append(line);
		        line = reader.readLine();  
		    }  
			
			
		} catch (FileNotFoundException e) {  
		    e.printStackTrace();  
		} catch (IOException e) {  
		    e.printStackTrace();  
		}
		return sb.toString();  
    }
	
}
