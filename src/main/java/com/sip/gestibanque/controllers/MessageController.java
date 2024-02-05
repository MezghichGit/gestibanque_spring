package com.sip.gestibanque.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.sip.gestibanque.entities.Message;
import com.sip.gestibanque.entities.User;
import com.sip.gestibanque.repositories.MessageRepository;
import com.sip.gestibanque.repositories.UserRepository;

@Controller
@RequestMapping("/messages")
public class MessageController {

	@Autowired
	MessageRepository messageRepository;
	@Autowired
	UserRepository userRepository;

	@RequestMapping("/save")
	public String getFormAddMessage(Model model) {
		Message message = new Message();
		model.addAttribute("message", message);
		
		List<User> users = (List<User>) this.userRepository.findAll();
		model.addAttribute("users", users);

		return "message/addMessage";
	}

	@PostMapping("/save")
	public String saveMessage(Message message) {
		message.setDateMessage(LocalDate.now());
//		message.setEmailSender(message.getUser().getEmail());
		messageRepository.save(message); // save : insert

		return "redirect:list";
	}

	@RequestMapping("/list")
	public String getAllMessages(Model model) {
		List<Message> messages = (List<Message>) messageRepository.findAll(); // select *
		model.addAttribute("messages", messages);

		return "message/listMessage";
	}

	@RequestMapping("/delete/{id}")
	public String deleteMessage(@PathVariable("id") int id) {
		messageRepository.deleteById(id); // delete

		return "redirect:../list";
	}

	@GetMapping("/update/{id}")
	public String getFormUpdateMessage(@PathVariable("id") int id, Model model) {
		Optional<Message> opMessage = messageRepository.findById(id);
		Message message = opMessage.get(); // message qui est rempli depuis la base
		model.addAttribute("message", message);
		
		List<User> users = (List<User>) this.userRepository.findAll();
		model.addAttribute("users", users);

		return "message/updateMessage";
	}

	@PostMapping("/update")
	public String updateMessage(Message message) {
		messageRepository.save(message); // save : insert

		return "redirect:list";
	}
	
	@PostMapping("/search")
	public String getFormSearchMessage(Model model, @RequestParam(value = "dateMessage") LocalDate dateMessage) {

		List<Message> messages = messageRepository.findByDateMessage(dateMessage);
		model.addAttribute("messages", messages);

		return "message/listMessage";
//		return "redirect:list";
	}

}
