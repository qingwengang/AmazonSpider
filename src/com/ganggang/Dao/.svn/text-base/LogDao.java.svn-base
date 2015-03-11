package com.ganggang.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ganggang.Entity.CamelListUrl;
import com.ganggang.Entity.Log;
import com.ganggang.Util.HibernateUtil;

public class LogDao {
	public static void AddLog(Log log){
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
			session.save(log);
		session.getTransaction().commit();
		session.close();  
	}
}
