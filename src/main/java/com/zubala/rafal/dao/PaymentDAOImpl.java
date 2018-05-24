package com.zubala.rafal.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zubala.rafal.entity.Payment;

@Repository
public class PaymentDAOImpl implements PaymentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Payment> retrievePaymentsByUser(Long userId) {
		Session currentSession = sessionFactory.getCurrentSession();				
		String queryStr = "select p from Payment p "
				+ " inner join p.user User "				
				+ " where User.id = :userId"
				+ " order by p.date ASC ";
		TypedQuery<Payment> query = currentSession.createQuery(queryStr, Payment.class);
		query.setParameter("userId", userId);
		return query.getResultList();
	}

	@Override
	public void savePayment(Payment payment) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(payment);
	}
}
