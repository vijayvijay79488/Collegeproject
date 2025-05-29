package com.example.collegeproject.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "chat")
public class chatmode {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // Add an ID for entity mapping

	@Column(name = "sender", nullable = false, length = 50)
	private String sender;

	@Column(name = "receiver", nullable = false, length = 50)
	private String receiver;

	@Column(name = "message", columnDefinition = "TEXT")
	private String message;

	@Column(name = "createat")
	private LocalDateTime createAt;

	// Getters and Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}
}
