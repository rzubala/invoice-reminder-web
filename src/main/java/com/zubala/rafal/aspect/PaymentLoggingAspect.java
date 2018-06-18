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
	public Object savePayment(ProceedingJoinPoint joinPoint) throws Throwable {
		Object[] args = joinPoint.getArgs();
		Payment payment = (Payment) args[0];
		
		long begin = System.currentTimeMillis();
		Object result = joinPoint.proceed();
		long end = System.currentTimeMillis();
		long duration = end - begin;
		logger.info("savePayment: " + payment.toString() + " duration: " + duration + " ms");
		
		return result;
	}
}
