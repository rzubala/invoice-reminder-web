package com.zubala.rafal.service;

import java.util.LinkedList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zubala.rafal.dao.PaymentDAO;
import com.zubala.rafal.entity.CustomUser;
import com.zubala.rafal.entity.Payment;
import com.zubala.rafal.payment.PaymentData;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentDAO paymentDAO;
	
	@Override
	@Transactional
	public List<Payment> retrievePaymentsByUser(Long userId) {
		List<Payment> result = paymentDAO.retrievePaymentsByUser(userId);
		if (result == null) {
			return new LinkedList<>();
		}
		return result;
	}

	@Override
	@Transactional
	public void savePayment(PaymentData paymentData, CustomUser currentUser) {
		paymentDAO.savePayment(paymentData, currentUser);
	}
}
