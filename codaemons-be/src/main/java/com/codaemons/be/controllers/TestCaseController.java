package com.codaemons.be.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codaemons.be.models.TestCase;
import com.codaemons.be.services.TestCaseService;

@RestController
@RequestMapping(path="/api/v1/testcases", consumes="application/json", produces="application/json")
public class TestCaseController {
	
	private TestCaseService testCaseService;
	
	@Autowired
	public TestCaseController(TestCaseService testCaseService) {
		this.testCaseService = testCaseService;
	}
	
	@PostMapping
	public List<TestCase> addUpdateMultipleTestCases(@RequestBody List<TestCase> testCases) {
		testCaseService.saveAll(testCases);
		return testCases;
	}
	
	@GetMapping("/default/{questionID}")
	public TestCase getDefaultTestCaseForQuestionID(@PathVariable int questionID) {
		return testCaseService.getDefaultTestCase(questionID);
	}
	
	@GetMapping("/{questionID}")
	public List<TestCase> getAllTestCasesForQuestionID(@PathVariable int questionID){
		return testCaseService.getTestCasesByQuestionID(questionID);
	}
	
	
	/**
	 * Used to delete single test case by ID.
	 * @param testCaseID
	 * @return
	 */
	@DeleteMapping("/{testCaseID}")
	public int deleteTestCaseByID(@PathVariable int testCaseID) {
		testCaseService.deleteById(testCaseID);
		return testCaseID;
	}
	
	/**
	 * Used to delete multiple test cases.
	 * @param testCases
	 */
	@DeleteMapping
	public void deleteMultipleTestCases(@RequestBody List<TestCase> testCases) {
		testCaseService.deleteAll(testCases);
	}
	
}
