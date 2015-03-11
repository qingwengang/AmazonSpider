package com.ganggang.Dao.Box;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.ganggang.Entity.Box.BoxCategory;
import com.ganggang.Entity.Box.BoxProduct;
import com.ganggang.Util.HibernateUtil;

public class BoxProductDao {

	public static void Add(BoxProduct product){
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(product);
		session.getTransaction().commit();
		session.close();  
	}
	public static List<String> GetProductIds(){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		List<String> ls=new LinkedList<String>();
		List list=session.createSQLQuery("select DISTINCT CONCAT(Type,OutId) from boxproduct").list();
		for(Iterator iterator =list.iterator();iterator.hasNext();){
			ls.add((String)iterator.next());
		}
		session.close();
		return ls;
	}
	public static void Update(BoxProduct product) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.update(product);
		session.getTransaction().commit();
		session.close();
	}
	public static List<BoxProduct> GetUnSipderDetailInfo(){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Criteria c = session.createCriteria(BoxProduct.class);
		c.add(Restrictions.eq("detailInfoFlag", 0));
		c.setFirstResult(0);
		c.setMaxResults(10);
		List<BoxProduct> ca = c.list();
		for (BoxProduct product : ca) {
			product.setDetailInfoFlag(1);
			Update(product);
		}
		session.close();
		return ca;
	}
	public static List<BoxProduct> GetUnSipderPriceHistory(){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Criteria c = session.createCriteria(BoxProduct.class);
		c.add(Restrictions.eq("priceHistoryFlag", 0));
		c.setFirstResult(0);
		c.setMaxResults(10);
		List<BoxProduct> ca = c.list();
		for (BoxProduct product : ca) {
			product.setDetailInfoFlag(1);
			Update(product);
		}
		session.close();
		return ca;
	}

}
