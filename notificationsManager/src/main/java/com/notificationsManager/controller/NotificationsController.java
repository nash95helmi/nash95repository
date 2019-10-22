package com.notificationsManager.controller;

import java.io.PrintStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.notificationsManager.model.Mail;
import com.notificationsManager.service.EmailService;

@RestController
public class NotificationsController {
	
	@Autowired
	private EmailService emailService;

	@RequestMapping(value = "/registrationDetails" , method = RequestMethod.POST)
	public Boolean registrationDetails(@RequestBody Mail mail) {
		try {
			emailService.sendSimpleMessage(mail);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}
