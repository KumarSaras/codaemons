package com.codaemons.be.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codaemons.be.models.Users;

@Repository
public interface UsersRepository extends CrudRepository<Users, Integer> {
	
	Users findById(int userID);
	
	Users findByUsername(String username);
	
	@Query("select u.username from Users u")
	List<String> findAllUsernames();

	@Query("select u from Users u where username = ?1 and password = ?2")
	Users getUserInfo(String username, String password);
	
}