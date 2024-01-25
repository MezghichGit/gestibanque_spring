package com.sip.gestibanque.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sip.gestibanque.entities.CompteBancaire;
import com.sip.gestibanque.repositories.CompteRepository;
import com.sip.gestibanque.repositories.MessageRepository;

@Controller
@RequestMapping("/comptes")
public class CBController {
	@Autowired  // iOC(inversion of control) = Injection de dépendances
	CompteRepository compteRepository;
	
	@RequestMapping("/save")
//	@ResponseBody
	public String getComptesForm(Model model) {
		CompteBancaire cb = new CompteBancaire();
		model.addAttribute("cb", cb);
		return "compte/compteForm";
	}
	
	@PostMapping("/save")
	public String saveCompte(CompteBancaire cb) {
		compteRepository.save(cb);
		return "redirect:list";
		
		
	}
	
	
}
