package com.ganggang.Dao.Stock;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.ganggang.Stock.Entity.StockInfo;
import com.ganggang.Stock.Entity.StockTransactionDetail;
import com.ganggang.Util.HibernateUtil;

public class StockTransactionDetailDao {

	public static void AddStockTransactionDetail(StockTransactionDetail detail) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
//		Criteria c = session.createCriteria(StockTransactionDetail.class);
//		c.add(Restrictions.eq("code", detail.getCode()));
//		c.add(Restrictions.eq("transactionDate", detail.getTransactionDate()));
//		if (c.list().size() == 0) {
			session.save(detail);
//		}
		session.getTransaction().commit();
		session.close();
	}
}
