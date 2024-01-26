package com.sip.gestibanque.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.sip.gestibanque.entities.CompteBancaire;
import com.sip.gestibanque.repositories.CompteRepository;

@Controller
@RequestMapping("/comptes")
public class CompteController {
	@Autowired
	CompteRepository compteRepository;

	@RequestMapping("/save")
	public String getFormAddCompte(Model model) {
		CompteBancaire cb = new CompteBancaire();
		model.addAttribute("cb", cb);

		return "compte/addCompte";
	}

	@PostMapping("/save")
	public String saveCompte(CompteBancaire cb) {
		compteRepository.save(cb); // save : insert

		return "redirect:list";
	}

	@GetMapping("/list")
	public String getAllComptes(Model model) {
		List<CompteBancaire> cbs = (List<CompteBancaire>) compteRepository.findAll(); // select *
		model.addAttribute("comptes", cbs);

		return "compte/listCompte";
	}

	@GetMapping("/delete/{id}")
	public String deleteCompte(@PathVariable("id") int id) {
		compteRepository.deleteById(id); // delete

		return "redirect:../list";
	}

	@GetMapping("/update/{id}")
	public String getFormUpdateCompte(@PathVariable("id") int id, Model model) {
		Optional<CompteBancaire> opCompte = compteRepository.findById(id);
		CompteBancaire cb = opCompte.get(); // compte qui est rempli depuis la base
		model.addAttribute("compte", cb);

		return "compte/updateCompte";
	}

	@PostMapping("/update")
	public String updateCompte(CompteBancaire cb) {
		compteRepository.save(cb); // save : insert

		return "redirect:list";
	}

	@PostMapping("/search")
	public String getFormSearchCompte(Model model, @RequestParam(value = "proprietaire") String proprietaire) {

		List<CompteBancaire> cbs = compteRepository.findByProprietaire(proprietaire);
		model.addAttribute("comptes", cbs);

		return "compte/listCompte";
//		return "redirect:list";
	}

}
