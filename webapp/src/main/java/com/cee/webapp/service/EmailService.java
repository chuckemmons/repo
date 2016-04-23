package com.cee.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.cee.webapp.model.Contact;

@Service("emailService")
@PropertySource({"/WEB-INF/classes/email.properties"})
public class EmailService {

	@Autowired
	MailSender mailSender;
	
	@Value("${email.to.address}")
	String toAddress;
	
	@Value("${email.subject.contact.prepend}")
	String subjectContactPrepend;

	public void sendMailFrom(Contact contact) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(toAddress);
		message.setSubject(subjectContactPrepend + " "
				+ contact.getFullName());
		message.setText(contact.getMessageWithSignature());
		mailSender.send(message);
	}

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
}
