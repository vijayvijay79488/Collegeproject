package com.example.collegeproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.collegeproject.model.chatmode;

public interface chatrepo extends JpaRepository<chatmode, Long> {
	List<chatmode> findBySenderOrReceiver(String senter, String receiver);

	@Query("SELECT c FROM chatmode c WHERE (c.sender = :user1 AND c.receiver = :user2) OR (c.sender = :user2 AND c.receiver = :user1) ORDER BY c.createAt")
	List<chatmode> findConversation(@Param("user1") String user1, @Param("user2") String user2);

}