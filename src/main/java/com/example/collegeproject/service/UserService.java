package com.example.collegeproject.service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Base64;

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



	public UserDTO LoginUser(loginDTO user) throws manaul {
	    User one = userRepository.findByEmail(user.getEmail());
	    UserDTO throee = new UserDTO();

	    if (one != null) {
	        if (one.getPasswordHash().equals(user.getPassword())) {
	        	throee.setId(one.getUserId());
	            throee.setEmail(one.getEmail());
	            throee.setFullName(one.getFullName());
	            throee.setLocation(one.getLocation());
	            throee.setPassword(one.getPasswordHash());
	            throee.setPhone(one.getPhone());
	          throee.setProfilePicture(encodeBase64Image(one.getProfilePicture()));
	            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	            if (one.getDob() != null) {
	                String dobString = one.getDob().format(formatter);
	                throee.setDob(dobString);
	            }

	            return throee; // Don't forget to return!
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
	public static String encodeBase64Image(byte[] base64Dat) {
		String base64= Base64.getEncoder().encodeToString(base64Dat);
		return "data:image/png;base64,"+base64;
	}
	public static byte[] decodeBase64Image(String base64Data) {
	    if (base64Data == null) {
	        throw new IllegalArgumentException("Base64 data is null");
	    }
	    String[] parts = base64Data.split(",");
	    String base64Image;
	    if (parts.length > 1) {
	        base64Image = parts[1];  // typical data URL format
	    } else {
	        base64Image = parts[0];  // just raw base64 string without prefix
	    }
	    return Base64.getDecoder().decode(base64Image);
	}

}
