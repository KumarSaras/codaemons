package com.codaemons.be.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codaemons.be.models.UserRoles;

@Repository
public interface UserRolesRepository extends CrudRepository<UserRoles, Integer> {

}
