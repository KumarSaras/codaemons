package com.codaemons.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codaemons.dao.LanguageServiceDAO;
import com.codaemons.models.Lanugages;

@RestController
@RequestMapping("/test")
public class LanguageController {

	@Autowired
	private LanguageServiceDAO languageService;
	
	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello from CodeDaemons!";
	}
	
	@GetMapping("/dbconnection")
	public List<Lanugages> testDatabaseConnection() {
		List<Lanugages> languageList = languageService.findAll();		
		return languageList;
	}
}
