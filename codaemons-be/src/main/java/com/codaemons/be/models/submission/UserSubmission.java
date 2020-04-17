package com.codaemons.be.models.submission;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "user_submission")
public class UserSubmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long submission_id;

    private int submission_language_id;
    private Long test_case_id;
    private String test_case_result;
    private int test_case_exec_time;
    private String test_case_exec_memory;
    private int submission_time_taken;
    private String updated_date;

    public Long getSubmission_id() {
        return submission_id;
    }

    public void setSubmission_id(Long submission_id) {
        this.submission_id = submission_id;
    }

    public int getSubmission_language_id() {
        return submission_language_id;
    }

    public void setSubmission_language_id(int submission_language_id) {
        this.submission_language_id = submission_language_id;
    }

    public Long getTest_case_id() {
        return test_case_id;
    }

    public void setTest_case_id(Long test_case_id) {
        this.test_case_id = test_case_id;
    }

    public String getTest_case_result() {
        return test_case_result;
    }

    public void setTest_case_result(String test_case_result) {
        this.test_case_result = test_case_result;
    }

    public int getTest_case_exec_time() {
        return test_case_exec_time;
    }

    public void setTest_case_exec_time(int test_case_exec_time) {
        this.test_case_exec_time = test_case_exec_time;
    }

    public String getTest_case_exec_memory() {
        return test_case_exec_memory;
    }

    public void setTest_case_exec_memory(String test_case_exec_memory) {
        this.test_case_exec_memory = test_case_exec_memory;
    }

    public int getSubmission_time_taken() {
        return submission_time_taken;
    }

    public void setSubmission_time_taken(int submission_time_taken) {
        this.submission_time_taken = submission_time_taken;
    }

    public String getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(String updated_date) {
        this.updated_date = updated_date;
    }
}
