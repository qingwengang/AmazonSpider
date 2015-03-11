package com.ganggang.Dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.ganggang.Entity.CamelCategory;
import com.ganggang.Entity.ProxyInfo;
import com.ganggang.Util.HibernateUtil;

public class ProxyInfoDao {
//	public static Proxy GetUnSpiderCategory(){
//		SessionFactory sf=HibernateUtil.getSessionFactory();
//		Session session=sf.openSession();
//		Criteria c=session.createCriteria(CamelCategory.class);
//		c.add(Restrictions.eq("flag", 0));
//		c.setFirstResult(0);
//		c.setMaxResults(1);
//		CamelCategory ca= (CamelCategory) (c.list().size()>0?c.list().get(0):null);
//		session.close();
//		return ca;
//	}
}
