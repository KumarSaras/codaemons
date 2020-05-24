package com.codaemons.be.models.submission;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Base64;

@Entity @IdClass(UserSubmissionKey.class)
@Table(name = "user_submissions")

public class UserSubmission implements Serializable {

    @Id
    @Column(name = "submission_id")
    private int submissionId;
    @Id
    @Column(name = "submission_language_id")
    private int submissionLanguageId;
    @Id
    @Column(name = "test_case_id")
    private int testCaseId;

    @Column(name = "test_case_result" )
    private String testCaseResult;

    @Column(name = "test_case_exec_time")
    private double testCaseExecTime;

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

    public int getTestCaseId() {
        return testCaseId;
    }

    public void setTestCaseId(int testCaseId) {
        this.testCaseId = testCaseId;
    }

    public String getTestCaseResult() {
        return testCaseResult;
    }

    public void setTestCaseResult(String testCaseResult) {
        this.testCaseResult = testCaseResult;
    }

    public double getTestCaseExecTime() {
        return testCaseExecTime;
    }

    public void setTestCaseExecTime(double testCaseExecTime) {
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
        //return this.sourceCode;
        byte[] actualByte = Base64.getDecoder().decode(this.sourceCode);
        return new String(actualByte);
    }

    public void setSourceCode(String sourceCode) {

        this.sourceCode = Base64.getEncoder().encodeToString(sourceCode.getBytes());
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }
}


