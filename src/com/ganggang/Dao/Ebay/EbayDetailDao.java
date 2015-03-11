package com.ganggang.Dao.Ebay;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.ganggang.Entity.Mulu;
import com.ganggang.Entity.Ebay.EbayCategory;
import com.ganggang.Entity.Ebay.EbayDetail;
import com.ganggang.Util.HibernateUtil;

public class EbayDetailDao {
	public static void AddEbayDetail(EbayDetail ebayDetail){
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		if(!Check(session,ebayDetail)){
			session.save(ebayDetail);
		}
		session.getTransaction().commit();
		session.close();  
	}
	
	public static Boolean Check(Session session,EbayDetail ebayDetail){
		Criteria c=session.createCriteria(EbayDetail.class);
		c.add(Restrictions.eq("ebayID", ebayDetail.getUrl()));
		return c.list().size()>0;
	}
	public static EbayDetail GetUnSpiderFlag(){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		Criteria c=session.createCriteria(EbayDetail.class);
		c.add(Restrictions.eq("flag", 0));
		c.setFirstResult(0);
		c.setMaxResults(1);
		EbayDetail ca= (EbayDetail) (c.list().size()>0?c.list().get(0):null);
		session.close();
		return ca;
	}
	public static EbayDetail GetUnSpiderCommentUrlFlag(){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		Criteria c=session.createCriteria(EbayDetail.class);
		c.add(Restrictions.eq("commentUrlFlag", 0));
		c.setFirstResult(0);
		c.setMaxResults(1);
		EbayDetail ca= (EbayDetail) (c.list().size()>0?c.list().get(0):null);
		session.close();
		return ca;
	}
	public static EbayDetail GetUnSpiderCommentFlag(){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		Criteria c=session.createCriteria(EbayDetail.class);
		c.add(Restrictions.eq("commentFlag", 0));
		c.setFirstResult(0);
		c.setMaxResults(1);
		EbayDetail ca= (EbayDetail) (c.list().size()>0?c.list().get(0):null);
		session.close();
		return ca;
	}
	public static EbayDetail GetSpiderCommentFlag(){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		Criteria c=session.createCriteria(EbayDetail.class);
		c.add(Restrictions.eq("commentFlag", 1));
		c.setFirstResult(0);
		c.setMaxResults(1);
		EbayDetail ca= (EbayDetail) (c.list().size()>0?c.list().get(0):null);
		session.close();
		return ca;
	}
	public static void UpdateEbayDetail(EbayDetail detail){
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.update(detail);
		session.getTransaction().commit();
		session.close();  
	}
}
