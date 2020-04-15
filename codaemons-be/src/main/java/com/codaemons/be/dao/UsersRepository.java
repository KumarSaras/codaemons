package com.codaemons.be.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codaemons.be.models.Users;

@Repository
public interface UsersRepository extends CrudRepository<Users, Integer> {
	
	Users findByUsername(String username);
	
	@Query("select u.username from Users u")
	List<String> findAllUsernames();
}