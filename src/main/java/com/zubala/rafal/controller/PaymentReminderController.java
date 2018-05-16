package com.zubala.rafal.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zubala.rafal.config.UserPrincipal;
import com.zubala.rafal.entity.CustomUser;

@Controller
@RequestMapping("/payment")
public class PaymentReminderController {

	@GetMapping("/list")
	public String listCustomers(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();		
		CustomUser user = ((UserPrincipal)authentication.getPrincipal()).getUser();
		
		model.addAttribute("username", user.getUsername());
		model.addAttribute("userId", user.getId());
		
		return "list-payments";
	}
}
