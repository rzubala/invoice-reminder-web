package com.zubala.rafal.dao;

import java.util.List;

import com.zubala.rafal.entity.Payment;

public interface PaymentDAO {

	List<Payment> retrievePaymentsByUser(Long userId);

}
