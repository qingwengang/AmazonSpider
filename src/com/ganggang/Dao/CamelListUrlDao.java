package com.ganggang.Dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.ganggang.Entity.CamelCategory;
import com.ganggang.Entity.CamelListUrl;
import com.ganggang.Entity.Mulu;
import com.ganggang.Util.HibernateUtil;

public class CamelListUrlDao {
	public static void AddCamelListUrl(CamelListUrl camelUrl){
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
//		if(!Check(camelUrl)){
			session.save(camelUrl);
//		}
		session.getTransaction().commit();
		session.close();  
	}
	
	public static Boolean Check(CamelListUrl camelUrl){
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		Criteria c=session.createCriteria(CamelListUrl.class);
		c.add(Restrictions.eq("amazonID",camelUrl.getAmazonID()));
		List<CamelListUrl> urlList=c.list();
		session.close();
		return urlList.size()>0;
	}
	public static List<CamelListUrl> GetUnSpiderCamelListUrl(int num){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		session.getTransaction().begin();
		Criteria c=session.createCriteria(CamelListUrl.class);
		c.add(Restrictions.eq("flag", 0));
		c.setFirstResult(0);
		c.setMaxResults(num);
		List<CamelListUrl> listUrls=c.list();
		for(CamelListUrl listUrl : listUrls){
			listUrl.setFlag(1);
			Update(listUrl);
		}
		session.getTransaction().commit();
		session.close();
		return listUrls;
	}
	public static List<CamelListUrl> GetUnSpiderAmazonComments(int num){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		Criteria c=session.createCriteria(CamelListUrl.class);
		c.add(Restrictions.eq("amazonFlag", 0));
		c.setFirstResult(0);
		c.setMaxResults(num);
		List<CamelListUrl> listUrls=c.list();
		for(CamelListUrl listUrl : listUrls){
			listUrl.setAmazonFlag(1);
			Update(listUrl);
		}
		session.close();
		return listUrls;
	}
	public static void Update(CamelListUrl listUrl){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		session.update(listUrl);
		session.getTransaction().commit();
		session.close();
	}
	
	public static List<CamelListUrl> GetCamelListUrl(String condition,int count){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		String sql=String.format("select * from camellisturl where %s limit 0,%d", condition,count);
		List<CamelListUrl> result=session.createSQLQuery(sql).addEntity(CamelListUrl.class).list();
		session.close();
		return result;
	}
	
	public static List<CamelListUrl> GetUnSpiderAmazonPrice(int num){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		Criteria c=session.createCriteria(CamelListUrl.class);
		c.add(Restrictions.eq("amazonPriceFlag", 0));
		c.setFirstResult(0);
		c.setMaxResults(num);
		List<CamelListUrl> result=c.list();
		session.close();
		return result;
	}
	public static List<CamelListUrl> GetUnSpiderOokongPrice(){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		Criteria c=session.createCriteria(CamelListUrl.class);
		c.add(Restrictions.eq("ookongPriceFlag", 0));
		c.setFirstResult(0);
		c.setMaxResults(100);
		List<CamelListUrl> result=c.list();
		session.close();
		for(CamelListUrl listUrl:result){
			listUrl.setOokongPriceFlag(1);
			Update(listUrl);
		}
		return result;
	}
	public static List<CamelListUrl> GetUnSpiderUnimercPrice(){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		Criteria c=session.createCriteria(CamelListUrl.class);
		c.add(Restrictions.eq("unimercPriceFlag", 0));
		c.setFirstResult(0);
		c.setMaxResults(100);
		List<CamelListUrl> result=c.list();
		session.close();
		for(CamelListUrl listUrl:result){
			listUrl.setUnimercPriceFlag(1);
			Update(listUrl);
		}
		return result;
	}
}
