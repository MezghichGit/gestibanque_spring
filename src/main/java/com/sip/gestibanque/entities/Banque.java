package com.sip.gestibanque.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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

	@Override
	public String toString() {
		return "Banque [id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", capital=" + capital + "]";
	}

	public Banque(int id, String nom, String adresse, double capital) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.capital = capital;
	}

	public Banque() {

	}

}
