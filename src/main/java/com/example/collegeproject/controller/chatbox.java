package com.example.collegeproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.collegeproject.DTO.fromto;
import com.example.collegeproject.model.chatmode;
import com.example.collegeproject.service.chatService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/chat")
public class chatbox {
	@Autowired
	private chatService chatservice;

	public chatbox(chatService chatService) {
		this.chatservice = chatService;
	}

	@PostMapping
	public chatmode saveMessage(@RequestBody fromto chat) {
		return chatservice.saveMessage(chat);
	}

	@GetMapping("/chat")
	public List<chatmode> getChatBetweenUsers(@RequestParam String from, @RequestParam String to) {

		return chatservice.getmessage(from, to);
	}
	

//	@GetMapping
//	public List<chatmode> getAllMessages() {
//		return chatservice.getAllMessages();
//	}

//	@GetMapping("/user/{username}")
//	public List<chatmode> getUserChats(@PathVariable String username) {
////		return chatservice.getUserChats(username);
//	}
}
