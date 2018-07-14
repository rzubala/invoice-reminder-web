package com.zubala.rafal.config.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.zubala.rafal.service.NotificationService;

@Component
public class NotificationScheduler {

	@Autowired
	private NotificationService notificationService;
    
	private Logger logger = Logger.getLogger(getClass());

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Async
    @Scheduled(cron = "0 25 * * * *")
    //@Scheduled(fixedDelay=5000)
    public void reportCurrentTime() {
    	logger.info("The time is now " + dateFormat.format(new Date()));
	
    	//FIXME
		//notificationService.sendSimpleMessage("rzubala@wp.pl", "Pay on time title", "Pay ont time content");
    }
}
