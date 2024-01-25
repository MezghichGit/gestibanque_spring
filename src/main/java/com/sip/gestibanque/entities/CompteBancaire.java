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
	
	public CompteBancaire() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(String proprietaire) {
		this.proprietaire = proprietaire;
	}

	public LocalDate getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getTypeCompte() {
		return typeCompte;
	}

	public void setTypeCompte(String typeCompte) {
		this.typeCompte = typeCompte;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public int getIdBanque() {
		return idBanque;
	}

	public void setIdBanque(int idBanque) {
		this.idBanque = idBanque;
	}
	
	
	
	
}
