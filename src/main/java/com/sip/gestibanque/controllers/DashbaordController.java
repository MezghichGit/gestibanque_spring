package com.sip.gestibanque.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sip.gestibanque.repositories.BanqueRepository;
import com.sip.gestibanque.repositories.CompteRepository;
import com.sip.gestibanque.repositories.MessageRepository;
import com.sip.gestibanque.repositories.UserRepository;

@Controller
@RequestMapping("/dashboard")
public class DashbaordController {
	
	 UserRepository userRepository;
	 BanqueRepository banqueRepository;
	 CompteRepository compteRepository;
	 MessageRepository messageRepository;
	
	 public DashbaordController(UserRepository userRepository, BanqueRepository banqueRepository,
			CompteRepository compteRepository, MessageRepository messageRepository) {
		super();
		this.userRepository = userRepository;
		this.banqueRepository = banqueRepository;
		this.compteRepository = compteRepository;
		this.messageRepository = messageRepository;
	}
	 
	 
	 @RequestMapping("/home")
	 //@ResponseBody
	  public String home(Model model) {
		 
		 
		 	long numberOfUsers = userRepository.count();
	        long numberOfBanques = banqueRepository.count();
	        long numberOfComptes = compteRepository.count();
	        long numberOfMessages = messageRepository.count();
	        
	        model.addAttribute("numberOfUsers", numberOfUsers);
	        model.addAttribute("numberOfBanques", numberOfBanques);
	        model.addAttribute("numberOfComptes", numberOfComptes);
	        model.addAttribute("numberOfMessages", numberOfMessages);
	        
	        return "dashboard/home";
		 
	 }
	 
	 
	 

}
