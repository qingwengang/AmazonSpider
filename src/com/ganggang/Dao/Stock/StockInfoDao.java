package com.ganggang.Dao.Stock;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.ganggang.Entity.CamelCategory;
import com.ganggang.Stock.Entity.StockInfo;
import com.ganggang.Util.HibernateUtil;

public class StockInfoDao {

	public static void AddStockInfo(StockInfo info){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		Criteria c=session.createCriteria(StockInfo.class);
		c.add(Restrictions.eq("code", info.getCode()));
		if(c.list().size()==0){
			session.save(info);
		}
		session.getTransaction().commit();
		session.close();
	}
	
	public static StockInfo GetUnSpiderHistoryStock(){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		Criteria c=session.createCriteria(StockInfo.class);
		c.add(Restrictions.eq("ifGetHistory", 0));
		c.setFirstResult(0);
		c.setMaxResults(1);
		StockInfo ca= (StockInfo) (c.list().size()>0?c.list().get(0):null);
		ca.setIfGetHistory(2);
		UpdateCategory(ca);
		session.close();
		return ca;
	}
	
	public static void UpdateCategory(StockInfo info){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		session.update(info);
		session.getTransaction().commit();
		session.close();
	}
}
