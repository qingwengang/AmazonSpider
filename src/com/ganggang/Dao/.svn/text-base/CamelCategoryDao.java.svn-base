package com.ganggang.Dao;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

import com.ganggang.Entity.CamelCategory;
import com.ganggang.Entity.CamelListUrl;
import com.ganggang.Entity.Mulu;
import com.ganggang.Util.HibernateUtil;

public class CamelCategoryDao {
	public static void AddCategory(CamelCategory camelCategory){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		Criteria c=session.createCriteria(CamelCategory.class);
		c.add(Restrictions.eq("categoryName", camelCategory.getCategoryName()));
		if(c.list().size()==0){
			session.save(camelCategory);
		}
		session.getTransaction().commit();
		session.close();
	}
	
	public static CamelCategory GetUnSpiderCategory(){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		Criteria c=session.createCriteria(CamelCategory.class);
		c.add(Restrictions.eq("flag", 0));
		c.setFirstResult(0);
		c.setMaxResults(1);
		CamelCategory ca= (CamelCategory) (c.list().size()>0?c.list().get(0):null);
		session.close();
		return ca;
	}
	public static void UpdateCategory(CamelCategory category){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		category.setUpdateTime(new Date());
		session.update(category);
		session.getTransaction().commit();
		session.close();
	}
}
