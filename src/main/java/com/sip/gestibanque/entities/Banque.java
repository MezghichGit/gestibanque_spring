package com.sip.gestibanque.entities;

import java.util.List;

import jakarta.persistence.*;

@Entity // On veut que Hibernate nous crée une table
public class Banque {

	@Id // clé primaire et unique
	@GeneratedValue(strategy = GenerationType.AUTO) // Hibernate qui va générer l'id automatiquement avant l'insertion
	private int id;
	private String nom;
	private String adresse;
	private double capital;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public double getCapital() {
		return capital;
	}

	public void setCapital(double capital) {
		this.capital = capital;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "banque")
	private List<CompteBancaire> comptesBancaires;

	public List<CompteBancaire> getComptesBancaires() {
		return comptesBancaires;
	}

	public void setComptesBancaires(List<CompteBancaire> comptesBancaires) {
		this.comptesBancaires = comptesBancaires;
	}

	@Override
	public String toString() {
		return "Banque [id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", capital=" + capital
				+ ", comptesBancaires=" + comptesBancaires + "]";
	}

	public Banque(int id, String nom, String adresse, double capital, List<CompteBancaire> comptesBancaires) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.capital = capital;
		this.comptesBancaires = comptesBancaires;
	}

	public Banque() {

	}

}
