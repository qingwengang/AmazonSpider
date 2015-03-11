package com.ganggang.Util.Mail;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MailProxy {

	public static void SendEmail(String title,String content){
		SimpleDateFormat bartDateFormat =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		Date date = new Date();  
		MyAuthenticator.Send(title, bartDateFormat.format(date)+":"+content);
	}
	public static void main(String[] args){
		SendEmail("fdsf", "fdsfs");
		System.out.println("fds");
	}
}
