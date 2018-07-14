package com.zubala.rafal.service;

import java.util.Date;
import java.util.List;

import com.zubala.rafal.entity.CustomUser;
import com.zubala.rafal.entity.Payment;
import com.zubala.rafal.payment.FilterData;
import com.zubala.rafal.payment.PaymentData;

public interface PaymentService {
	List<Payment> retrievePaymentsByUser(Long userId, FilterData filterData);

	void savePayment(PaymentData payment, CustomUser currentUser);

	Payment getPaymentById(int id);

	List<PaymentData> getPaymentData(List<Payment> payments);
	
	PaymentData getPaymentData(Payment payment);

	void deletePaymentById(int id);

	void markPaymentById(int id);

	List<Payment> retrievePaymentsByDate(Date date);
}
