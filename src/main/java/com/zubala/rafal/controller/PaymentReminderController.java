package com.zubala.rafal.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zubala.rafal.entity.CustomUser;
import com.zubala.rafal.entity.Payment;
import com.zubala.rafal.payment.PaymentData;
import com.zubala.rafal.service.ContextService;
import com.zubala.rafal.service.PaymentService;

@Controller
@RequestMapping("/payment")
public class PaymentReminderController {

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private ContextService context;
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		CustomUser user = context.getCurrentUser();
		
		model.addAttribute("username", user.getUsername());
		model.addAttribute("userId", user.getId());
		
		List<Payment> payments = paymentService.retrievePaymentsByUser(user.getId(), null);
		model.addAttribute("payments", payments);
		
		return "list-payments";
	}

	@GetMapping("/addPayment")
	public String showFormForAdd(Model theModel) {		
		PaymentData payment = new PaymentData();
		
		theModel.addAttribute("payment", payment);
		
		return "payment-form";
	}

	@PostMapping("/savePayment")
	public String savePayment(@Valid @ModelAttribute("payment") PaymentData payment, BindingResult bindingResult, Model model) {	
		if (bindingResult.hasErrors()) {
			model.addAttribute("payment", payment);
			String errorMessage = getErrorMessage(bindingResult);
			model.addAttribute("validationError", errorMessage);
			return "payment-form";	
		}
		
		paymentService.savePayment(payment, context.getCurrentUser());	
		return "redirect:/payment/list";
	}

	private String getErrorMessage(BindingResult bindingResult) {
		List<FieldError> fieldErrors = bindingResult.getFieldErrors();
		String result = "Fields can not be empty.";
		for (FieldError oe : fieldErrors) {
			String message = oe.getDefaultMessage();
			if (message != null && !message.isEmpty()) {
				String fieldName = oe.getField();
				if (fieldName != null && !fieldName.isEmpty()) {
					message = fieldName +": " + message;
				}
				return message;
			}
		}
		return result;
	}

	@GetMapping("/updatePayment")
	public String updatePayment(@RequestParam("paymentId") int id, Model model) {
		Payment payment = paymentService.getPaymentById(id);
		PaymentData paymentData = paymentService.getPaymentData(payment);
		model.addAttribute("payment", paymentData);
		return "payment-form";
	}
	
	@GetMapping("/removePayment")
	public String deleteCustomer(@RequestParam("paymentId") int id) {
		paymentService.deletePaymentById(id);
		return "redirect:/payment/list";
	}

	@GetMapping("/markPayment")
	public String markPayment(@RequestParam("paymentId") int id) {
		paymentService.markPaymentById(id);
		return "redirect:/payment/list";
	}

	@InitBinder
	private void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormat());
	    CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
	    binder.registerCustomEditor(Date.class, editor);

	    StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);		
		binder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	private String dateFormat() {
		return "dd/MM/yyyy";
	}
}
