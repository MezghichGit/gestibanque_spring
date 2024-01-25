package com.sip.gestibanque.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sip.gestibanque.entities.CompteBancaire;
import com.sip.gestibanque.repositories.CompteRepository;

@Controller
@RequestMapping("/comptes")
public class CBController {
	@Autowired  
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
	
	@GetMapping("/list")
	public String getAllComptes(Model model) {
		List<CompteBancaire> comptes = (List<CompteBancaire>) compteRepository.findAll();  // select *
		model.addAttribute("comptes", comptes);
		return "compte/listeCompte";
	}
	
	@GetMapping("/delete/{id}")
	//@ResponseBody
	public String deleteCompte(@PathVariable("id") int id)
	{
		compteRepository.deleteById(id);  
		
		return "redirect:../list";
	}
	
	@GetMapping("/update/{id}")
	public String getFormUpdateCompte(@PathVariable("id") int id, Model model)
	{
		Optional<CompteBancaire> opCompte = compteRepository.findById(id);
		CompteBancaire compte = opCompte.get(); 
		
		model.addAttribute("compte", compte);
		
		return "compte/updateCompte";
	}
	
	
	@PostMapping("/update")
	//@ResponseBody
	public String updateCompte(CompteBancaire compte)
	{
		compteRepository.save(compte);  
		return "redirect:list";
	}


	
}
