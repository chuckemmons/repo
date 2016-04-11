package com.cee.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.cee.webapp.model.Contact;

@Service("emailService")
public class EmailService {

	@Autowired
	MailSender mailSender;

	public void sendMailFrom(Contact contact) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("c.emmons@gmail.com");
		message.setSubject("webapp Contact Message From: "
				+ contact.getFullName());
		message.setText(contact.getMessageWithSignature());
		mailSender.send(message);
	}

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
}
