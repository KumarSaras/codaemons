package com.codaemons.be.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codaemons.be.models.UserAddress;

@Repository
public interface UserAddressRepository extends CrudRepository<UserAddress, Integer>{

	UserAddress findByEmailID(String emailID);
}
