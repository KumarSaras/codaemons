package com.codaemons.be.models.submission;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_submissions")
public class UserSubmission {

    @Id
    @Column(name = "submission_id")
    private int submissionId;

    @Column(name = "submission_language_id")
    private int submissionLanguageId;

    @Column(name = "test_case_id")
    private Long testCaseId;

    @Column(name = "test_case_result" )
    private String testCaseResult;

    @Column(name = "test_case_exec_time")
    private int testCaseExecTime;

    @Column(name = "test_case_exec_memory")
    private String testCaseExecMemory;

    @Column(name = "submission_time_taken")
    private int submissionTimeTaken;

    @Column(name = "source_code")
    private String sourceCode;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;


    public UserSubmission(){

    }

    public int getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(int submissionId) {
        this.submissionId = submissionId;
    }

    public int getSubmissionLanguageId() {
        return submissionLanguageId;
    }

    public void setSubmissionLanguageId(int submissionLanguageId) {
        this.submissionLanguageId = submissionLanguageId;
    }

    public Long getTestCaseId() {
        return testCaseId;
    }

    public void setTestCaseId(Long testCaseId) {
        this.testCaseId = testCaseId;
    }

    public String getTestCaseResult() {
        return testCaseResult;
    }

    public void setTestCaseResult(String testCaseResult) {
        this.testCaseResult = testCaseResult;
    }

    public int getTestCaseExecTime() {
        return testCaseExecTime;
    }

    public void setTestCaseExecTime(int testCaseExecTime) {
        this.testCaseExecTime = testCaseExecTime;
    }

    public String getTestCaseExecMemory() {
        return testCaseExecMemory;
    }

    public void setTestCaseExecMemory(String testCaseExecMemory) {
        this.testCaseExecMemory = testCaseExecMemory;
    }

    public int getSubmissionTimeTaken() {
        return submissionTimeTaken;
    }

    public void setSubmissionTimeTaken(int submissionTimeTaken) {
        this.submissionTimeTaken = submissionTimeTaken;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }
}
