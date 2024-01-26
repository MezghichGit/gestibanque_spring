package com.sip.gestibanque.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String sujet;
	private String description;
	private LocalDate dateMessage; 
	private String emailSender;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSujet() {
		return sujet;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDateMessage() {
		return dateMessage;
	}

	public void setDateMessage(LocalDate dateMessage) {
		this.dateMessage = dateMessage;
	}

	public String getEmailSender() {
		return emailSender;
	}

	public void setEmailSender(String emailSender) {
		this.emailSender = emailSender;
	}
	
	@Override
	public String toString() {
		return "Message [id=" + id + ", sujet=" + sujet + ", description=" + description + ", dateMessage="
				+ dateMessage + ", emailSender=" + emailSender + "]";
	}

	public Message(int id, String sujet, String description, LocalDate dateMessage, String emailSender) {
		super();
		this.id = id;
		this.sujet = sujet;
		this.description = description;
		this.dateMessage = dateMessage;
		this.emailSender = emailSender;
	}

	public Message() {
	
	}
	
}
