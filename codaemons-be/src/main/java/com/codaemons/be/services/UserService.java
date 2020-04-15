package com.codaemons.be.services;

import java.util.List;

import com.codaemons.be.beans.RegistrationRequest;

public interface UserService {

	boolean registerUser(RegistrationRequest request);
	
	List<String> getUsernameList();
}
