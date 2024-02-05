package com.sip.gestibanque.entities;

import java.time.LocalDate;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.*;

@Entity
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String sujet;
	private String description;
	private LocalDate dateMessage;
//	private String emailSender;

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

//	public String getEmailSender() {
//		return emailSender;
//	}
//
//	public void setEmailSender(String emailSender) {
//		this.emailSender = emailSender;
//	}

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_user", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", sujet=" + sujet + ", description=" + description + ", dateMessage="
				+ dateMessage + ", user=" + user + "]";
	}

	public Message(int id, String sujet, String description, LocalDate dateMessage, User user) {
		super();
		this.id = id;
		this.sujet = sujet;
		this.description = description;
		this.dateMessage = dateMessage;
		this.user = user;
	}

	public Message() {

	}

}
