package com.ganggang.Util.Mail;

import javax.mail.*;   

public class MyAuthenticator extends Authenticator{   
    String userName=null;   
    String password=null;   
        
    public MyAuthenticator(){   
    }   
    public MyAuthenticator(String username, String password) {    
        this.userName = username;    
        this.password = password;    
    }    
    protected PasswordAuthentication getPasswordAuthentication(){   
        return new PasswordAuthentication(userName, password);   
    }   
    
    public static void Send(String title,String content){
    	MailSenderInfo mailInfo = new MailSenderInfo();    
        mailInfo.setMailServerHost("smtp.163.com");    
        mailInfo.setMailServerPort("25");    
        mailInfo.setValidate(true);    
        mailInfo.setUserName("qwg880306@163.com");    
        mailInfo.setPassword("ganggang");//������������    
        mailInfo.setFromAddress("qwg880306@163.com");    
        mailInfo.setToAddress("qingwengang@gmail.com");    
        mailInfo.setSubject(title);    
        mailInfo.setContent(content);    
           //�������Ҫ�������ʼ�   
        SimpleMailSender sms = new SimpleMailSender();   
            sms.sendTextMail(mailInfo);//���������ʽ    
    }
    public static void main(String[] args){   
        //�������Ҫ�������ʼ�   
     MailSenderInfo mailInfo = new MailSenderInfo();    
     mailInfo.setMailServerHost("smtp.163.com");    
     mailInfo.setMailServerPort("25");    
     mailInfo.setValidate(true);    
     mailInfo.setUserName("qwg880306@163.com");    
     mailInfo.setPassword("ganggang");//������������    
     mailInfo.setFromAddress("qwg880306@163.com");    
     mailInfo.setToAddress("qingwengang@gmail.com");    
     mailInfo.setSubject("����������� ��http://www.guihua.org �й�����");    
     mailInfo.setContent("������������ ��http://www.guihua.org �й����� ���й�������վ==");    
        //�������Ҫ�������ʼ�   
     SimpleMailSender sms = new SimpleMailSender();   
         sms.sendTextMail(mailInfo);//���������ʽ    
         sms.sendHtmlMail(mailInfo);//����html��ʽ   
   }  
} 