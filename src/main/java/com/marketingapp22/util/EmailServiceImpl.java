package com.marketingapp22.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService{

	@Autowired
	private JavaMailSender sender;
	
	
	@Override
	public void sendEmail(String to, String sub, String msg) {
		SimpleMailMessage content= new SimpleMailMessage();
		content.setTo(to);
		content.setSubject(sub);
		content.setText(msg);
		sender.send(content);
		
	}

}
