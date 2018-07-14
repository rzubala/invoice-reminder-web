package com.zubala.rafal.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PaymentNotificationAspect {
	private Logger logger = Logger.getLogger(getClass());
	
	@Around("execution(* com.zubala.rafal.service.NotificationServiceImpl.sendSimpleMessage(..))")
	public Object sendSimpleMessage(ProceedingJoinPoint joinPoint) throws Throwable {
		Object[] args = joinPoint.getArgs();
		String to = (String) args[0];
		String subject = (String) args[1];
		String text = (String) args[2];
	
		String log = to + " " + subject + " " + text;
		
		long begin = System.currentTimeMillis();
		Object result = joinPoint.proceed();
		long end = System.currentTimeMillis();
		long duration = end - begin;
		logger.info("sendSimpleMessage: " + log + " duration: " + duration + " ms");
		
		return result;
	}

}
