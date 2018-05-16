package com.zubala.rafal.service;

import java.util.List;

import com.zubala.rafal.entity.Payment;

public interface PaymentService {
	List<Payment> retrievePaymentsByUser(Long userId);
}
