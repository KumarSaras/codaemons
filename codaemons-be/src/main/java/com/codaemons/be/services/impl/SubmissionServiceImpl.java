package com.codaemons.be.services.impl;

import com.codaemons.be.dao.UserContestRepository;
import com.codaemons.be.dao.UserSubmissionRepository;
import com.codaemons.be.models.TestCase;
import com.codaemons.be.models.submission.*;
import com.codaemons.be.services.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SubmissionServiceImpl implements SubmissionService {

    private RestTemplate restTemplate;
    private Judge0Response judge0Response;
    private Judge0Request judge0Request;
    private TestCase testCase;
    private UserContest userContestReturn;

    @Value("${judge0.submissions.uri}")
    private String judge0SubmissionURI;

    @Autowired
    private UserSubmissionRepository userSubmissionRepository;

    @Autowired
    private UserContestRepository userContestRepository;

    @Autowired
    private TestCaseServiceImpl testCaseService;

    public List<UserSubmission> findAll(){
        return userSubmissionRepository.findAll();
    }

    public Optional<UserSubmission> findBySubmissionID(final int submissionID){
        return userSubmissionRepository.findById(submissionID);
    }


    public String save(final UserSubmissionRequest userSubmissionRequest){
        //call for create submission
        restTemplate = new RestTemplate();
        judge0Request = new Judge0Request();
        judge0Request.setSource_code(userSubmissionRequest.getSourceCode());
        judge0Request.setLanguage_id(userSubmissionRequest.getLanguageId());
        if (userSubmissionRequest.getQuestionId() == 0){
            return "Question id is initial";
        }

        List<TestCase> testCases = testCaseService.getTestCasesByQuestionID(userSubmissionRequest.getQuestionId());
        if (testCases.size() == 0){
            return "Setup testcase first for question "+userSubmissionRequest.getQuestionId();
        }

        //User Contest
        UserContest userContest = new UserContest();
        userContest.setUserId(userSubmissionRequest.getUserId());
        userContest.setContestId(userSubmissionRequest.getContestId());
        // if (userSubmissionRequest.getQuestionId() != 0) {
        userContest.setQuestionId(userSubmissionRequest.getQuestionId());
        //  userContest.setSubmissionStatus(judge0Response.getStatusDescription());

        userContestReturn = userContestRepository.saveAndFlush(userContest);

        for (TestCase testCase:testCases) {
            judge0Request.setExpected_output(testCase.getTestCaseOutput());
            judge0Request.setStdin(testCase.getTestCaseInput());

            judge0Response = restTemplate.postForObject(judge0SubmissionURI, judge0Request, Judge0Response.class);

            //User submission
            UserSubmission userSubmission = new UserSubmission();
            userSubmission.setSubmissionId(userContestReturn.getSubmissionId());
            userSubmission.setSubmissionLanguageId(userSubmissionRequest.getLanguageId());
            userSubmission.setTestCaseId(testCase.getTestCaseID());
            userSubmission.setTestCaseResult(judge0Response.getStatusDescription());
            userSubmission.setSubmissionTimeTaken(0); //fix later
            //converting base64 in setter
            userSubmission.setSourceCode(userSubmissionRequest.getSourceCode());//(userSubmissionRequest.getSourceCode());
            // userSubmission.setUpdatedDate(LocalDateTime.now());
//        userSubmission.setSubmissionStatus(judge0Response.getStatus().getDescription());
            userSubmission.setUpdatedDate(LocalDateTime.now());
            userSubmissionRepository.save(userSubmission);
        }

        return "Result stored with submission id "+userContestReturn.getSubmissionId() ;
    }

    public String saveSimulation(final UserSubmissionRequest userSubmissionRequest){
        //call for create submission
        restTemplate = new RestTemplate();
        judge0Request = new Judge0Request();
        judge0Request.setSource_code(userSubmissionRequest.getSourceCode());
        judge0Request.setLanguage_id(userSubmissionRequest.getLanguageId());
        if (userSubmissionRequest.getQuestionId() == 0){
            return "Question id is initial";
        }

        testCase = testCaseService.getDefaultTestCase(userSubmissionRequest.getQuestionId());
        if (testCase == null){
            return "Setup default testcase first for question "+userSubmissionRequest.getQuestionId();
        }

        judge0Request.setExpected_output(testCase.getTestCaseOutput());
        judge0Request.setStdin(testCase.getTestCaseInput());

        judge0Response = restTemplate.postForObject(judge0SubmissionURI, judge0Request, Judge0Response.class);

        return "Status: "+judge0Response.getStatusDescription();
    }

}
