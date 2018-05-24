package com.zubala.rafal.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

	@PostMapping("/savePayment")
	public String savePayment(@ModelAttribute("payment") Payment payment) {	
		payment.setUser(getCurrentUser());
		paymentService.savePayment(payment);	
		return "redirect:/payment/list";
	}

	@InitBinder
	private void dateBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormat());
	    CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
	    binder.registerCustomEditor(Date.class, editor);
	}
	
	private String dateFormat() {
		return "dd/MM/yyyy";
	}

	private CustomUser getCurrentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();		
		CustomUser user = ((UserPrincipal)authentication.getPrincipal()).getUser();
		return user;
	}
}
