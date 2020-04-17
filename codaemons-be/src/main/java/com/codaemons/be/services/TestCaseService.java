package com.codaemons.be.services;

import java.util.List;

import com.codaemons.be.models.TestCase;

public interface TestCaseService {

	public void saveAll(List<TestCase> testCases);
	
	public void deleteById(int id);
	
	public void deleteAll(List<TestCase> testCases);
	
	public TestCase getDefaultTestCase(int questionID);
	
	public List<TestCase> getTestCasesByQuestionID(int questionID);
}
