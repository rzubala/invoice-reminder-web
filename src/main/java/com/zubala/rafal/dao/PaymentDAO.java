package com.zubala.rafal.dao;

import java.util.List;

import com.zubala.rafal.entity.CustomUser;
import com.zubala.rafal.entity.Payment;
import com.zubala.rafal.payment.PaymentData;

public interface PaymentDAO {

	List<Payment> retrievePaymentsByUser(Long userId, String filter);

	void savePayment(PaymentData paymentData, CustomUser currentUser);
}
