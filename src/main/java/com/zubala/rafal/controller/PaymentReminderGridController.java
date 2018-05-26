package com.zubala.rafal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zubala.rafal.entity.CustomUser;
import com.zubala.rafal.entity.Payment;
import com.zubala.rafal.payment.PaymentGrid;
import com.zubala.rafal.service.ContextService;
import com.zubala.rafal.service.PaymentService;

@RestController
@RequestMapping("/grid")
public class PaymentReminderGridController {

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private ContextService context;

	@GetMapping("listPayments")
	public PaymentGrid getListPayments() {
		CustomUser user = context.getCurrentUser();
		List<Payment> data = paymentService.retrievePaymentsByUser(user.getId());
		PaymentGrid grid = new PaymentGrid();
		grid.setData(data);
		grid.setDraw(1);
		grid.setRecordsTotal(data.size());
		grid.setRecordsFiltered(data.size());		
		return grid;
	}
}
