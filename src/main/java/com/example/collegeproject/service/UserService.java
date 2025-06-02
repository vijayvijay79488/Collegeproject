package com.example.collegeproject.service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.collegeproject.DTO.UserDTO;
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
	@Autowired
	private VendorService vendorservice;

	public String registerUser(UserDTO user) throws manaul {
	    User newone = new User();
	    newone.setUserId(null);
//	    newone.setCreatedAt(Timestamp.from(null));
	    newone.setFullName(user.getFullName());
	    newone.setEmail(user.getEmail());
	    newone.setPhone(user.getPhone());
	    newone.setLocation(user.getLocation());
	    newone.setPasswordHash(user.getPassword());

	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	    LocalDate parsedDob = LocalDate.parse(user.getDob(), formatter);
	    newone.setDob(parsedDob);

	    byte[] certBytes = vendorservice.decodeBase64Image(user.getProfilePicture());
	    newone.setProfilePicture(certBytes);

	    userRepository.save(newone);
	    return "saved";
	}



	public User LoginUser(loginDTO user) throws manaul {
		// TODO Auto-generated method stub
		User one = userRepository.findByEmail(user.getEmail());
		if (one != null) {
			if (one.getPasswordHash().equals(user.getPassword())) {
				return one;
//				return one.getFullName() + "  Login Succeful";
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
