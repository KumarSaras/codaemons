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
	public void deleteById(int id) {
		testCaseRepository.deleteById(id);
	}

	@Override
	public TestCase getDefaultTestCase(int questionID) {
		return testCaseRepository.getDefaultTestCase(questionID);
	}


	@Override
	public List<TestCase> getTestCasesByQuestionID(int questionID) {
		return testCaseRepository.getTestCasesByQuestionID(questionID);
	}

	@Override
	public void saveAll(List<TestCase> testCases) {
		
		//Setting current date and time in each entity before saving
		testCases.stream().forEach((testCase) -> testCase.setUpdatedDate(LocalDateTime.now()));
		testCaseRepository.saveAll(testCases);
	}

	@Override
	public void deleteAll(List<TestCase> testCases) {
		testCaseRepository.deleteAll(testCases);
	}

}
