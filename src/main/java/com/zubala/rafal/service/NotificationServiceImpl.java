package com.zubala.rafal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.zubala.rafal.entity.SettingsMail;

@Service
public class NotificationServiceImpl implements NotificationService {

	@Autowired
	public JavaMailSenderImpl emailSender;

	@Autowired
	private SettingsService settingsService;
	
	@Override
	public void sendSimpleMessage(String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		
		SettingsMail settings = settingsService.getSettingsMail();
		if (settings != null) {
			emailSender.setUsername(settings.getLogin());
			emailSender.setPassword(settings.getPassword());
		}
		
		emailSender.send(message);
	}
}
