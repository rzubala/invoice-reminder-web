package com.zubala.rafal.service;

import java.util.List;

import com.zubala.rafal.entity.CustomUser;
import com.zubala.rafal.entity.Payment;
import com.zubala.rafal.payment.PaymentData;

public interface PaymentService {
	List<Payment> retrievePaymentsByUser(Long userId);

	void savePayment(PaymentData payment, CustomUser currentUser);
}
