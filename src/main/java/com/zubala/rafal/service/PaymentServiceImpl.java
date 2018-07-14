package com.zubala.rafal.service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zubala.rafal.dao.PaymentDAO;
import com.zubala.rafal.entity.CustomUser;
import com.zubala.rafal.entity.Payment;
import com.zubala.rafal.payment.FilterData;
import com.zubala.rafal.payment.PaymentData;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentDAO paymentDAO;
	
	@Override
	@Transactional
	public List<Payment> retrievePaymentsByUser(Long userId, FilterData filterData) {
		List<Payment> result = paymentDAO.retrievePaymentsByUser(userId, filterData);
		if (result == null) {
			return new LinkedList<>();
		}
		return result;
	}

	@Override
	@Transactional
	public List<Payment> retrievePaymentsByDate(Date date) {
		List<Payment> result = paymentDAO.retrievePaymentsByDate(date);
		if (result == null) {
			return new LinkedList<>();
		}
		return result;
	}

	@Override
	@Transactional
	public void savePayment(PaymentData paymentData, CustomUser currentUser) {
		paymentDAO.savePayment(getPayment(paymentData), currentUser);
	}

	@Override
	@Transactional
	public Payment getPaymentById(int id) {
		return paymentDAO.retrievePaymentById(id);
	}

	private Payment getPayment(PaymentData data) {
		Payment payment = new Payment();
		if (data == null) {
			return payment;
		}
		payment.setAmount(data.getAmount());
		payment.setCurrency(data.getCurrency().toUpperCase());
		payment.setDate(data.getDate());
		payment.setDateStr(data.getDateStr());
		payment.setDescription(data.getDescription());
		payment.setId(data.getId());
		payment.setName(data.getName());
		payment.setPaid(data.getPaid());
		return payment;
	}

	@Override
	public List<PaymentData> getPaymentData(List<Payment> payments) {
		List<PaymentData> result = new LinkedList<>();
		if (payments == null || payments.isEmpty()) {
			return result;
		}
		for (Payment payment : payments) {
			result.add(getPaymentData(payment));
		}
		return result;
	}
	
	@Override
	public PaymentData getPaymentData(Payment payment) {
		Date now = new Date();
		PaymentData data = new PaymentData();
		if (payment == null) {
			return data;
		}
		data.setAmount(payment.getAmount());
		data.setCurrency(payment.getCurrency());
		data.setDate(payment.getDate());
		data.setDateStr(payment.getDateStr());
		data.setDescription(payment.getDescription());
		data.setId(payment.getId());
		data.setName(payment.getName());
		data.setPaid(payment.getPaid());
		data.setLate(getPaymentLate(payment, now));
		return data;
	}

	private boolean getPaymentLate(Payment payment, Date now) {
		boolean late = false;
		Date date = payment.getDate();
		Boolean paid = payment.getPaid();
		if (paid != null && paid) {
			return late;
		}
		if (date == null || now.after(date)) {
			late = true;
		}
		return late;
	}

	@Override
	@Transactional
	public void deletePaymentById(int id) {
		paymentDAO.deletePaymentById(id);
	}

	@Override
	@Transactional
	public void markPaymentById(int id) {
		paymentDAO.markPaymentById(id);
	}
}
