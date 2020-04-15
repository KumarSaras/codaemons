package com.codaemons.be.services.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codaemons.be.beans.RegistrationRequest;
import com.codaemons.be.dao.UserAddressRepository;
import com.codaemons.be.dao.UserRolesRepository;
import com.codaemons.be.dao.UsersRepository;
import com.codaemons.be.models.UserAddress;
import com.codaemons.be.models.UserRoles;
import com.codaemons.be.models.Users;

@Service
public class UserServiceImpl {

	@Autowired
	private UsersRepository usersDAO;
	
	@Autowired
	private UserAddressRepository userAddressDAO;

	@Autowired
	private UserRolesRepository userRolesDAO;
	
	public boolean registerUser(RegistrationRequest registrationRequest) {
		
		UserAddress userAddress = new UserAddress();
		//userAddress.setAddressLine1(registrationRequest.getAddressLine1());
		//userAddress.setAddressLine2(registrationRequest.getAddressLine2());
		//userAddress.setCity(registrationRequest.getCity());
		//userAddress.setCountry(registrationRequest.getCountry());
		//userAddress.setState(registrationRequest.getState());
		//userAddress.setZipcode(registrationRequest.getZipcode());
		userAddress.setEmailID(registrationRequest.getEmailID());
		userAddress.setContactNumber(registrationRequest.getContactNumber());
		userAddress.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
		userAddressDAO.save(userAddress);
		
		UserAddress userAddress1 = userAddressDAO.findByEmailID(userAddress.getEmailID());
		
		Users users = new Users();
		users.setUserFirstName(registrationRequest.getUserFirstName());
		users.setUserLastName(registrationRequest.getUserLastName());
		users.setUsername(registrationRequest.getUserName());
		users.setPassword(registrationRequest.getPassword());
		users.setUserAddressID(userAddress1.getUserAddressID());
		users.setUserActiveFlag('Y');
		users.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
		usersDAO.save(users);
		
		Users user1 = usersDAO.findByUsername(users.getUsername());
		
		UserRoles userRoles = new UserRoles();
		userRoles.setRoleID(2);
		userRoles.setUserID(user1.getUserID());
		userRoles.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
		userRolesDAO.save(userRoles);
		
		return true;
	}

	public List<String> getUsernameList() {
		List<String> usernameList = usersDAO.findAllUsernames();
		return usernameList;
	}
	
	
}
