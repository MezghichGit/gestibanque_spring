package com.sip.gestibanque.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CompteBancaire {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String proprietaire;
	private LocalDate dateCreation;
	private String typeCompte; // Epargne | Courant
	private double solde;
	private int idBanque;
	
	public CompteBancaire(int id, String proprietaire, LocalDate dateCreation, String typeCompte, double solde,
			int idBanque) {
		super();
		this.id = id;
		this.proprietaire = proprietaire;
		this.dateCreation = dateCreation;
		this.typeCompte = typeCompte;
		this.solde = solde;
		this.idBanque = idBanque;
	}
	
	
	
	
}
