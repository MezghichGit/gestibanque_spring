package com.sip.gestibanque.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sip.gestibanque.entities.Banque;
import com.sip.gestibanque.entities.Message;
import com.sip.gestibanque.repositories.MessageRepository;

@Controller
@RequestMapping("/messages")
public class MessageController {
	
	@Autowired  // iOC(inversion of control) = Injection de dépendances
	MessageRepository messageRepository;
	
	@RequestMapping("/save")
	@ResponseBody
	public String saveMessage()
	{
		// Objet message en dur
		Message message =  new Message();
		message.setSujet("Cursus Java");	
		message.setDescription("Bonjour Mr Amine, plus de détails sur le cursus");
		message.setDateCreation(LocalDate.now());
		message.setEmail("anne@gmail.com");
		
	
		Message savedMessage = messageRepository.save(message);  // save : insert
		return savedMessage.toString();
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public String getAllMessages()
	{
		List<Message> messages = (List<Message>) messageRepository.findAll();  // select *
		return messages.toString();
	}

}
