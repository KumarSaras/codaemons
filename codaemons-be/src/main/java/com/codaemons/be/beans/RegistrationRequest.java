package com.codaemons.be.beans;

import lombok.Data;

@Data
public class RegistrationRequest {

	private String userFirstName;
	private String userLastName;
	private String username;
	private String password;
    private String emailID;
}
