package com.ganggang.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ganggang.Entity.FailUrl;
import com.ganggang.Util.HibernateUtil;

public class FailUrlDao {
	public static void AddFailUrl(FailUrl failUrl){
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
			session.save(failUrl);
		session.getTransaction().commit();
		session.close();  
	}
	
	public static void AddFailUrl(String type,String url){
		AddFailUrl(new FailUrl(type,url));
	}
	public static void AddFailUrl(String type,String url,int outId){
		AddFailUrl(new FailUrl(type,url,outId));
	}
}
