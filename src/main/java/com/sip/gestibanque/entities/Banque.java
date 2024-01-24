package com.sip.gestibanque.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // on veut que hibernate nous crée une table
public class Banque {
	
	@Id  // clé primaire
	@GeneratedValue(strategy = GenerationType.AUTO)  // la clé primaire est auto-increment
	private int id;
	
	public Banque()
	{}

}
