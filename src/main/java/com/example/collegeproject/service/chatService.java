package com.example.collegeproject.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.collegeproject.DTO.fromto;
import com.example.collegeproject.model.chatmode;
import com.example.collegeproject.repository.chatrepo;

@Service
public class chatService {
	@Autowired
	private chatrepo chatrepo;

	public chatService(chatrepo chatRepository) {
		this.chatrepo = chatRepository;
	}

	public chatmode saveMessage(fromto chat) {
//		chat.setCreateAt(LocalDateTime.now());
//		chat.setId(null);
		chatmode oneee = new chatmode();
		oneee.setReceiver(chat.getReceiver());
		oneee.setSender(chat.getSender());
		oneee.setMessage(chat.getMessage());
		oneee.setCreateAt(LocalDateTime.now());
		System.out.println(chat.getReceiver());
		System.out.println(chat.getSender());

		return chatrepo.save(oneee);
	}

	public List<chatmode> getmessage(String sender, String recevieer) {
		return chatrepo.findConversation(sender, recevieer);
	}

//	public List<chatmode> getUserChats(String user) {
//		return chatrepo.findBySenterOrReceiver(user, user);
//	}
}