package com.codaemons.be.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codaemons.be.models.TestCase;
import com.codaemons.be.services.TestCaseService;

@RestController
@RequestMapping("/api/v1/testcases")
public class TestCaseController {
	
	private TestCaseService testCaseService;
	
	@Autowired
	public TestCaseController(TestCaseService testCaseService) {
		this.testCaseService = testCaseService;
	}
	
	@PostMapping
	private TestCase addTestCase(@RequestBody TestCase testCase) {
		
		testCaseService.save(testCase);
		
		return testCase;
	}
	
	@GetMapping("/default")
	private TestCase getDefaultTestCase() {
		return testCaseService.getDefaultTestCase();
	}
	
	@GetMapping("/{questionID}")
	private List<TestCase> getAllTestCasesForQuestionId(@PathVariable int questionID){
		return testCaseService.getTestCasesByQuestionID(questionID);
	}
	
}
