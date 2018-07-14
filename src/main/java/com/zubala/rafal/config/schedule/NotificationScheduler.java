package com.zubala.rafal.config.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.zubala.rafal.entity.CustomUser;
import com.zubala.rafal.entity.Payment;
import com.zubala.rafal.service.NotificationService;
import com.zubala.rafal.service.PaymentService;
import com.zubala.rafal.utils.Utility;

@Component
public class NotificationScheduler {

	@Autowired
	private NotificationService notificationService;

	@Autowired
	private PaymentService paymentService;
    
	private Logger logger = Logger.getLogger(getClass());

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Async
    @Scheduled(cron = "0 0 9 * * *")	//9 AM every day
    public void sendPaymentNotifications() {
    	Date now = new Date();
    	Date notificationDate = Utility.addDays(now, 1);
    	notificationDate = Utility.resetTimePart(notificationDate);
    	logger.info("sendPaymentNotifications: " + dateFormat.format(notificationDate));
    	
    	List<Payment> payments = paymentService.retrievePaymentsByDate(notificationDate, false);
    	processPayments(payments);
    }

	private void processPayments(List<Payment> payments) {
		if (payments == null || payments.isEmpty()) {
			return;
		}
		for (Payment payment : payments) {
			processPayment(payment);
		}
	}

	private void processPayment(Payment payment) {
		CustomUser user = payment.getUser();
		if (user == null) {
			return;
		}
		String email = user.getEmail();
		if (email == null || email.isEmpty()) {
			return;
		}
		String title = "Pay on time: " + payment.getName();
		String content = "Please be informed that payment " + payment.getName() + ": " + payment.getAmount() + " " + payment.getCurrency() + " should be paid tommorow.";
		notificationService.sendSimpleMessage(email, title, content);
	}
}
