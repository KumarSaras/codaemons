package com.codaemons.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.codaemons.dao.LanguageServiceDAO;
import com.codaemons.models.Lanugages;

@RestController
@RequestMapping("/api/v1")
public class LanguageController {

	@Autowired
	private LanguageServiceDAO languageService;
	
	@Value("${judge0.languages.uri}")
	private String judge0LanguagesURI;
	
	//Test endpoint
	@GetMapping("/hello")
	public String testEndpoint() {
		return "Hi from CodeDaemon";
	}
	
	//DB Test Endpoint
	@GetMapping("/dbtest")
	public String helloWorld() throws SQLException {
		
		Connection con = null;
		String dbHost = System.getenv("DB_URI"); //"jdbc:postgresql://localhost:5432/CodeDaemons"
		String message;
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:"+dbHost,"postgres","system");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from dev.languages");
			message = "Successful Hello";
		}
		catch(Exception e) {
			System.out.println(e);
			message = "Failed Hello";
		}
		finally {
			con.close();
		}
		
		return message;
	}
	
	//DB Connection Test Endpoint
	@GetMapping("/dbconnection")
	public List<Lanugages> testDatabaseConnection() {
		List<Lanugages> languageList = languageService.findAll();		
		return languageList;
	}
	
	//Judge0 API Test Endpoint
	@GetMapping("/languages")
	public String getJudge0Languages() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(judge0LanguagesURI, String.class);
	}
	
	
}
