package com.itgate.demo.Controlleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itgate.demo.models.Mail;
import com.itgate.demo.services.EmailService;

@CrossOrigin("*")
@RestController
@RequestMapping("/users/email")
public class MailController {

	@Autowired
	private EmailService emailService;

	@PostMapping("/sendMail")
	public String sendMail(@RequestBody Mail mail) {
		System.out.println("Spring Mail - Sending Simple Email with JavaMailSender Example");

		emailService.sendSimpleMessage(mail);
		return "ok";
	}

}
