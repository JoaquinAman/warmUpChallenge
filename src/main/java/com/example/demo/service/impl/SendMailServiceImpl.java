package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.service.SendMailService;

@Service
public class SendMailServiceImpl implements SendMailService {
	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void sendEmail(User user) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(user.getMail());
		mailMessage.setSubject("Bienvenido");
		mailMessage.setText("Su cuenta ha sido creada con exito");
		mailSender.send(mailMessage);
	}
}
