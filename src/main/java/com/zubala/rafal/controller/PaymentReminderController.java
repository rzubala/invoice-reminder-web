package com.zubala.rafal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/payment")
public class PaymentReminderController {

	@GetMapping("/list")
	public String listCustomers(Model model) {
		return "list-payments";
	}
}
