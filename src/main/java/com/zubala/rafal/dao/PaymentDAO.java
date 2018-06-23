package com.zubala.rafal.dao;

import java.util.List;

import com.zubala.rafal.entity.CustomUser;
import com.zubala.rafal.entity.Payment;
import com.zubala.rafal.payment.FilterData;

public interface PaymentDAO {

	List<Payment> retrievePaymentsByUser(Long userId, FilterData filterData);

	void savePayment(Payment payment, CustomUser currentUser);

	Payment retrievePaymentById(int id);

	void deletePaymentById(int id);

	void markPaymentById(int id);
}
