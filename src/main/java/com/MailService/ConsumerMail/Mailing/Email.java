package com.MailService.ConsumerMail.Mailing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class Email {
	 @Autowired
	    private JavaMailSender mailSender;

	    public void sendSimpleEmail(String toEmail, String subject, String body) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setFrom("springdemo236@gmail.com");
	        message.setTo(toEmail);
	        message.setSubject(subject);
	        message.setText(body);
	        mailSender.send(message);
	    }
}
