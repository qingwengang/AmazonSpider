package com.ganggang.Dao.Box;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.ganggang.Entity.CamelCategory;
import com.ganggang.Entity.CamelListUrl;
import com.ganggang.Entity.Mulu;
import com.ganggang.Entity.Box.BoxCategory;
import com.ganggang.Entity.Box.BoxProduct;
import com.ganggang.Util.HibernateUtil;

public class BoxCategoryDao {

	public static List<BoxCategory> GetUnSpiderCategory() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Criteria c = session.createCriteria(BoxCategory.class);
		c.add(Restrictions.eq("flag", 0));
		c.setFirstResult(0);
		c.setMaxResults(1);
		List<BoxCategory> ca = c.list();
		for (BoxCategory category : ca) {
			category.setFlag(1);
			Update(category);
		}
		session.close();
		return ca;
	}

	public static void Update(BoxCategory boxCategory) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.update(boxCategory);
		session.getTransaction().commit();
		session.close();
	}

	public static Boolean Check(Session session, BoxCategory boxCategory) {
		Criteria c = session.createCriteria(BoxCategory.class);
		c.add(Restrictions.eq("boxCategoryId", boxCategory.getBoxCategoryId()));
		c.add(Restrictions.eq("type", boxCategory.getType()));
		return c.list().size() > 0;
	}

	public static void Add(BoxCategory category) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		if (!Check(session, category)) {
			session.save(category);
		}
		session.getTransaction().commit();
		session.close();
	}

}
