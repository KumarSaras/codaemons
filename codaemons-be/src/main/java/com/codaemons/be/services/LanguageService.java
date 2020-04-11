package com.codaemons.be.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codaemons.be.dao.LanguageServiceDAO;
import com.codaemons.be.models.Lanugages;
import com.codaemons.be.repository.LanguageRepository;

@Service
public class LanguageService implements LanguageServiceDAO {

	@Autowired
	private LanguageRepository languageRepository;
	
	@Override
	public List<Lanugages> findAll() {
		List<Lanugages> languageList = (List<Lanugages>) languageRepository.findAll();
		return languageList;
	}

}