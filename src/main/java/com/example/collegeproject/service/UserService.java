package com.example.collegeproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.collegeproject.DTO.loginDTO;
import com.example.collegeproject.model.User;
import com.example.collegeproject.repository.UserRepository;

class manaul extends Exception {
	manaul(String msg) {
		super(msg);
	}
}

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public String registerUser(User user) throws manaul {
		if (userRepository.existsByEmail(user.getEmail()) || userRepository.existsByPhone(user.getPhone())) {
			throw new manaul("Already User Registered");
		}
		user.setUserId(null);
		userRepository.save(user);
		return "saved";
	}

	public String LoginUser(loginDTO user) throws manaul {
		// TODO Auto-generated method stub
		User one = userRepository.findByEmail(user.getEmail());
		if (one != null) {
			if (one.getPasswordHash().equals(user.getPassword())) {
				return one.getFullName() + "  Login Succeful";
			}
		}
		throw new manaul("Incorrect Input");
	}

	public String updatepassword(loginDTO user) throws manaul {
		// TODO Auto-generated method stub
		User one = userRepository.findByEmail(user.getEmail());
		if (one != null) {
			one.setPasswordHash(user.getPassword());
			userRepository.save(one);
			return "update";
		}
		throw new manaul("Email not found");
	}

}
