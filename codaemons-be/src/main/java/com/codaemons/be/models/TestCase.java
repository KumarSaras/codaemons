package com.codaemons.be.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="test_cases")
public class TestCase {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "test_case_id")
	private int testCaseID;
	
	@Column(name="question_id")
	private int questionID;
	
	@Column(name="contest_id")
	private Integer contestID;
	
	@Column(name="test_case_input")
	private String testCaseInput;
	
	@Column(name="test_case_output")
	private String testCaseOutput;
	
	//TODO: To be changed in DB to double precision
	@Column(name="max_time_allowed")
	private double maxTimeAllowed;
	
	//TODO: To be changed in DB to double precision
	@Column(name="max_memory_allowed")
	private double maxMemoryAllowed;
	
	//TODO: To be changed in DB to boolean
	@Column(name="test_case_active_flag")
	private boolean testCaseActiveFlag;
	
	@Column(name="test_case_default_flag")
	private boolean testCaseDefaultFlag;
	
	@Column(name="updated_date")
	private LocalDateTime updatedDate;

	public int getTestCaseID() {
		return testCaseID;
	}

	public void setTestCaseID(int testCaseID) {
		this.testCaseID = testCaseID;
	}

	public Integer getQuestionID() {
		return questionID;
	}

	public void setQuestionID(Integer questionID) {
		this.questionID = questionID;
	}

	public Integer getContestID() {
		return contestID;
	}

	public void setContestID(Integer contestID) {
		this.contestID = contestID;
	}

	public String getTestCaseInput() {
		return testCaseInput;
	}

	public void setTestCaseInput(String testCaseInput) {
		this.testCaseInput = testCaseInput;
	}

	public String getTestCaseOutput() {
		return testCaseOutput;
	}

	public void setTestCaseOutput(String testCaseOutput) {
		this.testCaseOutput = testCaseOutput;
	}

	public double getMaxTimeAllowed() {
		return maxTimeAllowed;
	}

	public void setMaxTimeAllowed(double maxTimeAllowed) {
		this.maxTimeAllowed = maxTimeAllowed;
	}

	public double getMaxMemoryAllowed() {
		return maxMemoryAllowed;
	}

	public void setMaxMemoryAllowed(double maxMemoryAllowed) {
		this.maxMemoryAllowed = maxMemoryAllowed;
	}

	public boolean isTestCaseActiveFlag() {
		return testCaseActiveFlag;
	}

	public void setTestCaseActiveFlag(boolean testCaseActiveFlag) {
		this.testCaseActiveFlag = testCaseActiveFlag;
	}

	public boolean isTestCaseDefaultFlag() {
		return testCaseDefaultFlag;
	}

	public void setTestCaseDefaultFlag(boolean testCaseDefaultFlag) {
		this.testCaseDefaultFlag = testCaseDefaultFlag;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

}
