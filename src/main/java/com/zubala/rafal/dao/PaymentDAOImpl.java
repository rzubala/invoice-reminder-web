package com.zubala.rafal.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zubala.rafal.entity.CustomUser;
import com.zubala.rafal.entity.Payment;
import com.zubala.rafal.payment.FilterData;

@Repository
public class PaymentDAOImpl implements PaymentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Payment> retrievePaymentsByUser(Long userId, FilterData filterData) {
		String filter = getValue(filterData.getFilter());
		boolean showPaid = getValue(filterData.getShowPaid(), true);
		Date showFrom = filterData.getShowFrom();
		
		Session currentSession = sessionFactory.getCurrentSession();				
		String queryStr = "select p from Payment p "
				+ " inner join p.user User "				
				+ " where User.id = :userId";		
		if (!filter.isEmpty()) {
			queryStr += " and (p.name like :name or p.description like :description ) ";
		}
		if (!showPaid) {
			queryStr += " and (p.paid = false or p.paid is null)  ";	
		}
		if (showFrom != null) {
			queryStr += " and (p.date >= :date or (p.paid = false or p.paid is null) ) ";	
		}
		queryStr += " order by p.date ASC ";
	
		TypedQuery<Payment> query = currentSession.createQuery(queryStr, Payment.class);
		query.setParameter("userId", userId);
		
		if (!filter.isEmpty()) {
			query.setParameter("name", "%" + filter + "%");
			query.setParameter("description", "%" + filter + "%");
		}
		if (showFrom != null) {
			query.setParameter("date", showFrom);
		}
		
		return query.getResultList();
	}

	@Override
	public List<Payment> retrievePaymentsByDate(Date date) {
		String queryStr = "select p from Payment p "
				+ " inner join fetch p.user User "				
				+ " where p.date = :date";		
		queryStr += " order by User.id ASC ";
	
		Session currentSession = sessionFactory.getCurrentSession();				
		TypedQuery<Payment> query = currentSession.createQuery(queryStr, Payment.class);
		query.setParameter("date", date);
		
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
		boolean paid = getValue(payment.getPaid(), false);
		payment.setPaid(!paid);

		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(payment);
	}

	private boolean getValue(Boolean value, boolean defaultValue) {
		if (value == null) {
			return defaultValue;
		}
		return value;
	}

	private String getValue(String filter) {
		if (filter == null) {
			return "";
		}
		return filter.trim();
	}
}
