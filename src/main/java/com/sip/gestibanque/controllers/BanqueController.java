package com.sip.gestibanque.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sip.gestibanque.entities.Banque;
import com.sip.gestibanque.repositories.BanqueRepository;

@Controller
@RequestMapping("/banques")
public class BanqueController {
	
	@Autowired  // iOC(inversion of control) = Injection de dépendances
	BanqueRepository banqueRepository;
	
	@RequestMapping("/save")
	@ResponseBody
	public String saveBanque()
	{
		// Objet banque en dur
		Banque banque =  new Banque();
		banque.setNom("Nikel");
		banque.setCapital(200000);
		banque.setAdresse("Bordeaux");
		
		// insertion dans la base de données de l'objet banque
		Banque res = banqueRepository.save(banque);  // save : insert
		return res.toString();
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public String getAllBanques()
	{
		List<Banque> banques = (List<Banque>) banqueRepository.findAll();  // select *
		return banques.toString();
	}
	
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public String deleteBanque(@PathVariable("id") int id)
	{
		banqueRepository.deleteById(id);  // delete
		List<Banque> banques = (List<Banque>) banqueRepository.findAll(); 
		return banques.toString();
	}
	
	@RequestMapping("/update/{id}")
	@ResponseBody
	public String updateBanque(@PathVariable("id") int id)
	{
		//Banque banque =  new Banque();
		Optional<Banque> op_banque = banqueRepository.findById(id);
		Banque banque = op_banque.get();
		
		
		banque.setNom("Nikel France");
		banque.setCapital(600000);
		banque.setAdresse("Bordeaux France");
		banque.setId(id);
		
		// insertion dans la base de données de l'objet banque
		Banque res = banqueRepository.save(banque);  // save : update
		return res.toString();
	}
	
	

}
