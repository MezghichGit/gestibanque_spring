package com.sip.gestibanque.entities;

import java.time.LocalDate;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;

@Entity
public class CompteBancaire {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String proprietaire;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateCreation;
	private String typeCompte; // Epargne | Courant
	private double solde;
//	private int idBanque;

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

//	public int getIdBanque() {
//		return idBanque;
//	}
//
//	public void setIdBanque(int idBanque) {
//		this.idBanque = idBanque;
//	}

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_banque", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Banque banque;

	public Banque getBanque() {
		return banque;
	}

	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	@Override
	public String toString() {
		return "CompteBancaire [id=" + id + ", proprietaire=" + proprietaire + ", dateCreation=" + dateCreation
				+ ", typeCompte=" + typeCompte + ", solde=" + solde + ", banque=" + banque + "]";
	}

	public CompteBancaire(int id, String proprietaire, LocalDate dateCreation, String typeCompte, double solde,
			Banque banque) {
		super();
		this.id = id;
		this.proprietaire = proprietaire;
		this.dateCreation = dateCreation;
		this.typeCompte = typeCompte;
		this.solde = solde;
		this.banque = banque;
	}

	public CompteBancaire() {

	}

}
