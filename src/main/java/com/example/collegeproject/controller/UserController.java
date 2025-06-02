package com.example.collegeproject.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.collegeproject.DTO.UserDTO;
import com.example.collegeproject.DTO.loginDTO;
import com.example.collegeproject.model.User;
import com.example.collegeproject.service.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/register")
	ResponseEntity<Map<String, Object>> registerUser(@RequestBody UserDTO user) {
		Map<String, Object> res = new HashMap<String, Object>();

		try {
			String response = userService.registerUser(user);
			res.put("status", HttpStatus.OK);
			res.put("response", response);
		} catch (Exception e) {
			res.put("status", HttpStatus.BAD_REQUEST);
			res.put("message", e.getMessage());
		}
		return new ResponseEntity<Map<String, Object>>(res, (HttpStatusCode) res.get("status"));

	}

	@PostMapping("/Login")
	ResponseEntity<Map<String, Object>> LoginUser(@RequestBody loginDTO user) {
		Map<String, Object> res = new HashMap<String, Object>();

		try {
			User response = userService.LoginUser(user);
			res.put("status", HttpStatus.OK);
			res.put("response", response);
		} catch (Exception e) {
			res.put("status", HttpStatus.BAD_REQUEST);
			res.put("message", e.getMessage());
		}
		return new ResponseEntity<Map<String, Object>>(res, (HttpStatusCode) res.get("status"));

	}

	@PostMapping("/updatepassword")
	ResponseEntity<Map<String, Object>> updatepassword(@RequestBody loginDTO user) {
		Map<String, Object> res = new HashMap<String, Object>();

		try {
			String response = userService.updatepassword(user);
			res.put("status", HttpStatus.OK);
			res.put("response", response);
		} catch (Exception e) {
			res.put("status", HttpStatus.BAD_REQUEST);
			res.put("message", e.getMessage());
		}
		return new ResponseEntity<Map<String, Object>>(res, (HttpStatusCode) res.get("status"));

	}

}
