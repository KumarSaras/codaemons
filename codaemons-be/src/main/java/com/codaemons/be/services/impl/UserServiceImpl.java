package com.codaemons.be.services.impl;

import java.util.Base64;

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
	private UsersRepository usersRespository;

	@Autowired
	private UserAddressRepository userAddressRespository;

	@Autowired
	private UserRolesRepository userRolesRespository;

	public boolean registerUser(RegistrationRequest registrationRequest) {
		try {
			UserAddress newUserAddress = insertUserAddress(registrationRequest.getEmailID());
			Users newUser = insertUser(registrationRequest, newUserAddress.getUserAddressID());
			insertUserRole(newUser.getUserID());
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean isUsernameAvailable(String username) {
		Users user = usersRespository.findByUsername(username);
		if(user != null) {
			return false;
		}
		return true;
	}
	
	public boolean isEmailAvailable(String emailID) {
		UserAddress userAddress = userAddressRespository.findByEmailID(emailID);
		if(userAddress != null) {
			return false;
		}
		return true;
	}

	public Users getUserDetails(String username, String password) {
		try {
			Users user = usersRespository.getUserInfo(username, Base64.getEncoder().encodeToString(password.getBytes()));
			return user;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	//Helper Methods
	private UserAddress insertUserAddress(String emailID) {

		try {
			UserAddress userAddress = new UserAddress();
			userAddress.setEmailID(emailID);
			return userAddressRespository.save(userAddress);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private Users insertUser(RegistrationRequest registrationRequest, int userAddressID) {
		try {
			Users users = new Users();
			users.setUserFirstName(registrationRequest.getUserFirstName());
			users.setUserLastName(registrationRequest.getUserLastName());
			users.setUsername(registrationRequest.getUsername());
			users.setPassword(Base64.getEncoder().encodeToString(registrationRequest.getPassword().getBytes()));
			users.setUserAddressID(userAddressID);
			users.setUserActiveFlag(Boolean.TRUE);
			
			return usersRespository.save(users);
		}
		catch(Exception e) {
			e.printStackTrace();
			removeFromUserAddress(userAddressID);
			return null;
		}
	}

	private UserRoles insertUserRole(int userID) {
		try {
			UserRoles userRoles = new UserRoles();
			userRoles.setRoleID(1);
			userRoles.setUserID(userID);
			return userRolesRespository.save(userRoles);
		}
		catch(Exception e) {
			e.printStackTrace();
			removeFromUserAddress(getUserAddressIDFromUser(userID));
			removeFromUsers(userID);
			return null;
		}
		
	}

	private int getUserAddressIDFromUser(int userID) {
		Users user = usersRespository.findById(userID);
		return user.getUserAddressID();
	}

	private void removeFromUserAddress(Integer userAddressID) {
		userAddressRespository.deleteById(userAddressID);
	}

	private void removeFromUsers(int userID) {
		usersRespository.deleteById(userID);

	}

}
