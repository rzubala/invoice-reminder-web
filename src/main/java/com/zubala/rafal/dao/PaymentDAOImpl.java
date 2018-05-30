package com.zubala.rafal.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zubala.rafal.entity.CustomUser;
import com.zubala.rafal.entity.Payment;
import com.zubala.rafal.payment.PaymentData;

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
	public void savePayment(PaymentData paymentData, CustomUser user) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Payment payment = new Payment();
		payment.setId(paymentData.getId());
		payment.setDate(paymentData.getDate());
		payment.setName(paymentData.getName());
		payment.setDescription(paymentData.getDescription());
		payment.setAmount(paymentData.getAmount());
		payment.setCurrency(paymentData.getCurrency());
		payment.setPaid(paymentData.getPaid());
		payment.setUser(user);
		
		currentSession.saveOrUpdate(payment);
	}
}
