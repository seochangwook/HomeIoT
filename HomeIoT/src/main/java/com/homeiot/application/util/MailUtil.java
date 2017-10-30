package com.homeiot.application.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailUtil {
	@Autowired
    public JavaMailSender emailSender;
	
	@Value("${spring.mail.username}")
	private String senderMail;
	
	public void sendSimpleMessage(String to) {
		System.out.println("to: " + to);
		System.out.println("sender: " + senderMail);
		
		SimpleMailMessage message = new SimpleMailMessage();
		
        message.setTo(to);
        message.setFrom(senderMail);
        message.setSubject("Home IoT - Motion Alarm");
        message.setText("test email");
        
        emailSender.send(message);
	}
}
