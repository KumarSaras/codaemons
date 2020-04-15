package com.codaemons.be.services;

import java.util.List;

import com.codaemons.be.models.TestCase;

public interface TestCaseService {

	public void save(TestCase testCase);
	
	public void deleteById(int id);
	
	public TestCase getDefaultTestCase();
	
	public List<TestCase> getTestCasesByQuestionID(int questionID);
}
