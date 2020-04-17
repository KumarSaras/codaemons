package com.codaemons.be.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codaemons.be.models.TestCase;

@Repository
public interface TestCaseRepository extends CrudRepository<TestCase, Integer> {
	
	@Query("select tc from TestCase tc where tc.testCaseDefaultFlag=true and tc.questionID=?1")
	public TestCase getDefaultTestCase(int questionID);
	
	@Query("select tc from TestCase tc where tc.questionID=?1")
	public List<TestCase> getTestCasesByQuestionID(int questionID);
}
