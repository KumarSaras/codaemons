package com.codaemons.be.beans;

import lombok.Data;

@Data
public class RegistrationRequest {

	private String userFirstName;
	private String userLastName;
	private String userName;
	private String password;
	//private String addressLine1;
    //private String addressLine2;
    //private String city;
    //private String state;
    //private String country;
    //private Integer zipcode;
    private String emailID;
    private Double contactNumber;
	
}
