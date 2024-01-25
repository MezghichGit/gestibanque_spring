package com.sip.gestibanque.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
		message.setDateMessage(LocalDate.now());
		message.setEmailSender("anne@gmail.com");
		
		Message savedMessage = messageRepository.save(message);  // save : insert
		
		return savedMessage.toString();
	}
	
	@RequestMapping("/list")
//	@ResponseBody
	public String getAllMessages(Model model)
	{
		List<Message> messages = (List<Message>) messageRepository.findAll();  // select *
		model.addAttribute("messages", messages);
		
//		return messages.toString();
		return "message/listMessage";
	}
	
	@RequestMapping("/delete/{id}")
//	@ResponseBody
	public String deleteMessage(@PathVariable("id") int id)
	{
		messageRepository.deleteById(id);  // delete
		
		return "redirect:../list";
	}
	
	@GetMapping("/update/{id}")
	public String getFormUpdateMessage(@PathVariable("id") int id, Model model)
	{
		Optional<Message> opMessage = messageRepository.findById(id);
		Message message = opMessage.get(); //message qui est remplis depuis la base
		
		model.addAttribute("message", message);
		
//		return messages.toString();
		return "message/updateMessage";
	}
	
	@PostMapping("/update")
	//@ResponseBody
	public String updateMessage(Message message)
	{
		messageRepository.save(message);  // save : insert
		
		return "redirect:list";
	}

}
