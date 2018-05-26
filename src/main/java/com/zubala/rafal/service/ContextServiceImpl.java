package com.zubala.rafal.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.zubala.rafal.config.UserPrincipal;
import com.zubala.rafal.entity.CustomUser;

@Component
public class ContextServiceImpl implements ContextService {

	@Override
	public CustomUser getCurrentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();		
		CustomUser user = ((UserPrincipal)authentication.getPrincipal()).getUser();
		return user;
	}
}
