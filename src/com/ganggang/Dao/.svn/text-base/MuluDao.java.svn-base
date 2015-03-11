package com.ganggang.Dao;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Check;
import org.hibernate.criterion.Restrictions;

import com.ganggang.Entity.Mulu;
import com.ganggang.Util.HibernateUtil;

public class MuluDao {
	public static void AddMulu(Mulu mulu) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		if (!Check(session, mulu)) {
			session.save(mulu);
		} else {
			Criteria c = session.createCriteria(Mulu.class);
			c.add(Restrictions.eq("url", mulu.getUrl()));
			Mulu m=(Mulu) c.list().get(0);
			m.setFlag(0);
			session.update(m);
		}
		session.getTransaction().commit();
		session.close();
	}

	public static Boolean Check(Session session, Mulu mulu) {
		Criteria c = session.createCriteria(Mulu.class);
		c.add(Restrictions.eq("url", mulu.getUrl()));
		return c.list().size() > 0;
	}

	public static Mulu GetUnSpiderMulu() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Criteria c = session.createCriteria(Mulu.class);
		c.add(Restrictions.eq("flag", 0));
		c.setFirstResult(0);
		c.setMaxResults(1);
		Mulu m = (Mulu) (c.list().size() > 0 ? c.list().get(0) : null);
		session.close();
		return m;
	}

	public static void UpdateMulu(Mulu mulu) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		if (!Check(session, mulu)) {
			mulu.setLastUpdateTime(new Date());
			session.save(mulu);
		}
		session.getTransaction().commit();
		session.close();
	}

	public static void UpdateMuluFlag(Mulu mulu) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		mulu.setLastUpdateTime(new Date());
		session.update(mulu);
		session.getTransaction().commit();
		session.close();
	}
}
