package com.codaemons.be.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codaemons.be.beans.LoginRequest;
import com.codaemons.be.beans.RegistrationRequest;
import com.codaemons.be.exception.CodaemonsResourceException;
import com.codaemons.be.models.Users;
import com.codaemons.be.services.impl.UserServiceImpl;

@RestController
@RequestMapping("/api/v1/user")
public class UsersController {

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@GetMapping("/username/availability/{username}")
	public ResponseEntity<String> checkUsernameAvailability(@PathVariable("username") String username) {
		if(userServiceImpl.isUsernameAvailable(username)) {
			return new ResponseEntity<String>("Username is available", new HttpHeaders(), HttpStatus.OK);
		}
		return new ResponseEntity<String>("Username already exists! Please enter a new username", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/email/availability/{email}")
	public ResponseEntity<String> checkEmailAvailability(@PathVariable("email") String emailID) {
		if(userServiceImpl.isEmailAvailable(emailID)) {
			return new ResponseEntity<String>("No registered user with this email", new HttpHeaders(), HttpStatus.OK);
		}
		throw new CodaemonsResourceException("A user with this email already exists!");
	}
	
	@PostMapping("/registration")
	public ResponseEntity<String> registerNewUser(@RequestBody RegistrationRequest registrationRequest) {
		boolean status = userServiceImpl.registerUser(registrationRequest);
		if(status) {
			return new ResponseEntity<String>("User registered successfully", new HttpHeaders(), HttpStatus.OK);
		}
		throw new CodaemonsResourceException("User not registered successfully");
	}
	
	@PostMapping("/login")
	public ResponseEntity<Users> userLogin(@RequestBody LoginRequest loginRequest) {
		Users user = userServiceImpl.getUserDetails(loginRequest.getUsername(), loginRequest.getPassword());
		if(user != null) {
			return new ResponseEntity<Users>(user, new HttpHeaders(), HttpStatus.OK);
		}
		throw new CodaemonsResourceException("User registration failed");
	}

}
