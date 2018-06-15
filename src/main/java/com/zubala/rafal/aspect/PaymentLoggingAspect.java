package com.zubala.rafal.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

import com.zubala.rafal.entity.Payment;

@Aspect
@Component
public class PaymentLoggingAspect {
	
	private Logger logger = Logger.getLogger(getClass());
	
	@Around("execution(* com.zubala.rafal.dao.PaymentDAOImpl.savePayment(..))")
	public void savePayment(ProceedingJoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		Payment payment = (Payment) args[0];
		logger.info("savePayment: " + payment.getId());
	}
}
