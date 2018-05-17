package com.zubala.rafal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zubala.rafal.config.UserPrincipal;
import com.zubala.rafal.entity.CustomUser;
import com.zubala.rafal.entity.Payment;
import com.zubala.rafal.service.PaymentService;

@Controller
@RequestMapping("/payment")
public class PaymentReminderController {

	@Autowired
	private PaymentService paymentService;
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		CustomUser user = getCurrentUser();
		
		model.addAttribute("username", user.getUsername());
		model.addAttribute("userId", user.getId());
		
		List<Payment> payments = paymentService.retrievePaymentsByUser(user.getId());
		model.addAttribute("payments", payments);
		
		return "list-payments";
	}

	@GetMapping("/addPayment")
	public String showFormForAdd(Model theModel) {		
		Payment payment = new Payment();
		
		theModel.addAttribute("payment", payment);
		
		return "payment-form";
	}
	
	private CustomUser getCurrentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();		
		CustomUser user = ((UserPrincipal)authentication.getPrincipal()).getUser();
		return user;
	}
}
