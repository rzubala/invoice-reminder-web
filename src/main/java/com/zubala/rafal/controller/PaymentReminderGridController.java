package com.zubala.rafal.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
	public PaymentGrid getListPayments(HttpServletRequest request) {
		String filter = request.getParameter("search[value]");
		Object draw = request.getParameter("draw");
		
		CustomUser user = context.getCurrentUser();
		List<Payment> data = paymentService.retrievePaymentsByUser(user.getId(), filter);
		
		PaymentGrid grid = new PaymentGrid();
		grid.setData(data);
		grid.setDraw(draw);
		grid.setRecordsTotal(data.size());
		grid.setRecordsFiltered(data.size());		
		return grid;
	}
}
