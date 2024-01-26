package com.sip.gestibanque.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sip.gestibanque.repositories.BanqueRepository;
import com.sip.gestibanque.repositories.CompteRepository;
import com.sip.gestibanque.repositories.MessageRepository;
import com.sip.gestibanque.repositories.UserRepository;

@Controller
//@RequestMapping("/dashboard")
public class DashboardController {

	@Autowired
	BanqueRepository banqueRepository;
	@Autowired
	CompteRepository compteRepository;
	@Autowired
	MessageRepository messageRepository;
	@Autowired
	UserRepository userRepository;

//	public DashboardController(UserRepository userRepository, BanqueRepository banqueRepository,
//			CompteRepository compteRepository, MessageRepository messageRepository) {
//		super();
//		this.userRepository = userRepository;
//		this.banqueRepository = banqueRepository;
//		this.compteRepository = compteRepository;
//		this.messageRepository = messageRepository;
//	}

	@RequestMapping(value = { "", "/", "/home" })
	public String home(Model model) {

		long nbreBanques = banqueRepository.count();
		long nbreComptes = compteRepository.count();
		long nbreMessages = messageRepository.count();
		long nbreUsers = userRepository.count();

		model.addAttribute("numberOfBanques", nbreBanques);
		model.addAttribute("numberOfComptes", nbreComptes);
		model.addAttribute("numberOfMessages", nbreMessages);
		model.addAttribute("numberOfUsers", nbreUsers);

		return "dashboard/home";

	}

}
