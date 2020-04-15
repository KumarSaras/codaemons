package com.codaemons.be.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codaemons.be.beans.RegistrationRequest;
import com.codaemons.be.services.impl.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UsersController {

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@GetMapping("/usernames")
	public ResponseEntity<List<String>> getAllUsernames() {
		List<String> usernameList = userServiceImpl.getUsernameList();
		return new ResponseEntity<List<String>>(usernameList, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping("/registration")
	public ResponseEntity<String> registerNewUser(@RequestBody RegistrationRequest registrationRequest) {
		boolean status = userServiceImpl.registerUser(registrationRequest);
		if(status) {
			return new ResponseEntity<String>("Successful", new HttpHeaders(), HttpStatus.OK);
		}
		return new ResponseEntity<String>("Failed", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
