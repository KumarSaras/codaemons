package com.codaemons.be.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.codaemons.be.dao.UsersRepository;
import com.codaemons.be.models.Users;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users codaemonsUser = usersRepository.findByUsername(username);
		return new User(codaemonsUser.getUsername(), codaemonsUser.getPassword(), new ArrayList<GrantedAuthority>());
	}

}