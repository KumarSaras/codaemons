package com.codaemons.be.services.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codaemons.be.dao.TestCaseRepository;
import com.codaemons.be.models.TestCase;
import com.codaemons.be.services.TestCaseService;

@Service
public class TestCaseServiceImpl implements TestCaseService {

	private TestCaseRepository testCaseRepository;
	
	@Autowired
	public TestCaseServiceImpl(TestCaseRepository testCaseRepository) {
		this.testCaseRepository = testCaseRepository;
	}
	
	@Override
	public void save(TestCase testCase) {
		
		//To avoid id being passed from consumer
		testCase.setTestCaseID(0);
		//Setting current date and time before saving
		testCase.setUpdatedDate(LocalDateTime.now());
		
		testCaseRepository.save(testCase);
	}

	@Override
	public void deleteById(int id) {
		testCaseRepository.deleteById(id);
	}

	@Override
	public TestCase getDefaultTestCase() {
		return testCaseRepository.getDefaultTestCase();
	}


	@Override
	public List<TestCase> getTestCasesByQuestionID(int questionID) {
		return testCaseRepository.getTestCasesByQuestionID(questionID);
	}

}
