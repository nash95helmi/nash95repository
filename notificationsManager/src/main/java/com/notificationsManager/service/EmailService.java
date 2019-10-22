package com.notificationsManager.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.notificationsManager.model.Mail;
import com.notificationsManager.model.MailAttachment;

@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender emailSender;
	
	public void sendSimpleMessage(Mail mail) throws MessagingException {
		
		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message,true);
		
		helper.setTo(mail.getTo());
		helper.setFrom(mail.getFrom());
		helper.setSubject(mail.getSubject());
		helper.setText(mail.getBodyContent());
		
		MailAttachment mailAttachment = mail.getMailAttachment();
		if(mailAttachment != null && mailAttachment.getFile() != null) {
			final InputStreamSource source = new ByteArrayResource(mailAttachment.getFile());
			helper.addAttachment(mailAttachment.getFileName(), source, mailAttachment.getMimeType());
		}
		
		emailSender.send(message);
	}
}
