package com.codaemons.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codaemons.models.Lanugages;

@Repository
public interface LanguageRepository extends CrudRepository<Lanugages, Integer> {
	
}
