package com.ganggang.Dao.Ebay;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.ganggang.Entity.CamelCategory;
import com.ganggang.Entity.Ebay.EbayCategory;
import com.ganggang.Entity.Ebay.EbayDetail;
import com.ganggang.Util.HibernateUtil;

public class EbayCategoryDao {
	
	public static EbayCategory GetUnSpiderCategory(){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		Criteria c=session.createCriteria(EbayCategory.class);
		c.add(Restrictions.eq("flag", 0));
		c.setFirstResult(0);
		c.setMaxResults(1);
		EbayCategory ca= (EbayCategory) (c.list().size()>0?c.list().get(0):null);
		session.close();
		return ca;
	}
	
	public static void UpdateEbayCategory(EbayCategory detail){
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.update(detail);
		session.getTransaction().commit();
		session.close();  
	}
}
