package com.niitconnect.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.niitconnect.model.Users;

@Service
public class EmailService {
	public static final String REPLY_TO_ADDRESS="donotreply@niitconnect.com";
	public static final String FROM_ADDRESS="registration@niitconnect.com";
	@Autowired
	private JavaMailSender javaMailSender;
	public void  send(Users user,String subject,String body) throws MessagingException
	{
		System.out.println("Inside mail");
		MimeMessage mail=javaMailSender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(mail,true);
		helper.setTo(user.getEmail());
		helper.setReplyTo(REPLY_TO_ADDRESS);
		helper.setFrom(FROM_ADDRESS);
		helper.setSubject(subject);
		helper.setText(body);
		helper.setText(body);
		javaMailSender.send(mail);
	}
	

}
