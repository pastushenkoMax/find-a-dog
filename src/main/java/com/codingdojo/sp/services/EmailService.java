package com.codingdojo.sp.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.sp.models.MessageEmail;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;
	
	public void sendEmail(String toEmail, String body, String subject) {
		
		SimpleMailMessage message = new SimpleMailMessage();
		
		
		message.setFrom("findadog.com@gmail.com");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);
		
		mailSender.send(message);
		
	}
	public String to (MessageEmail mail, BindingResult result) {
		if(result.hasErrors()) {
    		return null;
    	}else {
        String toEmail = mail.getToEmail();
        return toEmail;
    	}
        
    }
	
	public String subject (MessageEmail mail, BindingResult result) {
		if(result.hasErrors()) {
    		return null;
    	}else {
    		String subject = mail.getSubject();
    		return subject;
    	}
        
    }
	public String body (MessageEmail mail, BindingResult result) {
		if(result.hasErrors()) {
    		return null;
    	}else {
    		
        String body = mail.getBody();
        String fromName = mail.getFromName();
        String subject = mail.getSubject();
        String emailString = mail.getFromEmail();
        String newBody = "Hello, user " + fromName + " trying to reach you out, about " + subject +", here his Email " +emailString+ " thank you! \n \n" + body;
        return newBody;
    	}
       
        
    }
}
