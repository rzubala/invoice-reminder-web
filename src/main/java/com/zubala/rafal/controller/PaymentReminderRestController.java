package com.zubala.rafal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zubala.rafal.payment.PaymentData;

@RestController
@RequestMapping("/api")
public class PaymentReminderRestController {

	@GetMapping("listPayments")
	public PaymentData getListPayments() {
		PaymentData data = new PaymentData();
		data.setName("aaa");
		data.setDescription("bbb");
		return data;
		/*
		return "{\n" + 
				"  \"draw\": 1,\n" + 
				"  \"recordsTotal\": 57,\n" + 
				"  \"recordsFiltered\": 57" +
				"}";
		*/
	}
	

}
