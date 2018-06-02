package com.zubala.rafal.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zubala.rafal.entity.CustomUser;
import com.zubala.rafal.entity.Payment;

@Repository
public class PaymentDAOImpl implements PaymentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Payment> retrievePaymentsByUser(Long userId, String filter) {
		Session currentSession = sessionFactory.getCurrentSession();				
		String queryStr = "select p from Payment p "
				+ " inner join p.user User "				
				+ " where User.id = :userId";
		boolean isFilter = false;
		if (filter != null && !filter.trim().isEmpty()) {
			isFilter = true;
			queryStr += " and (p.name like :name or p.description like :description ) ";
		}		
		queryStr += " order by p.date ASC ";
		TypedQuery<Payment> query = currentSession.createQuery(queryStr, Payment.class);
		query.setParameter("userId", userId);
		if (isFilter) {
			query.setParameter("name", "%" + filter + "%");
			query.setParameter("description", "%" + filter + "%");
		}
		return query.getResultList();
	}

	@Override
	public void savePayment(Payment payment, CustomUser user) {
		Session currentSession = sessionFactory.getCurrentSession();
		payment.setUser(user);
		currentSession.saveOrUpdate(payment);
	}

	@Override
	public Payment retrievePaymentById(int id) {
		Session currentSession = sessionFactory.getCurrentSession();				
		String queryStr = "select p from Payment p where p.id = :id";
		TypedQuery<Payment> query = currentSession.createQuery(queryStr, Payment.class);
		query.setMaxResults(1);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	@Override
	public void deletePaymentById(int id) {
		Payment payment = retrievePaymentById(id);
		if (payment == null) {
			return;
		}
		
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.delete(payment);
	}

	@Override
	public void markPaymentById(int id) {
		Payment payment = retrievePaymentById(id);
		if (payment == null) {
			return;
		}
		boolean paid = getValue(payment.getPaid());
		payment.setPaid(!paid);

		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(payment);
	}

	private boolean getValue(Boolean value) {
		if (value == null) {
			return false;
		}
		return value;
	}
}
