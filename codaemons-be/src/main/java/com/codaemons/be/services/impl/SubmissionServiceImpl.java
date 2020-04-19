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

import java.util.List;

@Service
public class SubmissionServiceImpl implements SubmissionService {

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

    public String save(final UserSubmissionRequest userSubmissionRequest){

        Judge0Request judge0Request = new Judge0Request();
        judge0Request.setSource_code(userSubmissionRequest.getSourceCode());

        if(userSubmissionRequest.getExpectedOutput() != "") {
            judge0Request.setExpected_output(userSubmissionRequest.getExpectedOutput());
        }else{
            if (userSubmissionRequest.getQuestionId() != 0){
            TestCase testCase = testCaseService.getTestCasesByQuestionID(userSubmissionRequest.getQuestionId()).get(0);
            judge0Request.setExpected_output(testCase.getTestCaseOutput());
            judge0Request.setStdin(testCase.getTestCaseInput());
            }
        }
        judge0Request.setLanguage_id(userSubmissionRequest.getLanguageId());

//        call for create submission
        RestTemplate restTemplate = new RestTemplate();
        Judge0Response judge0Response = restTemplate.postForObject(judge0SubmissionURI, judge0Request, Judge0Response.class);

        //User Contest
        UserContest userContest = new UserContest();
        userContest.setUserId(userSubmissionRequest.getUserId());
        userContest.setContestId(userSubmissionRequest.getContestId());
       // if (userSubmissionRequest.getQuestionId() != 0) {
        userContest.setQuestionId(userSubmissionRequest.getQuestionId());
       // }else{
           // userContest.setQuestionId(0);
      //  }

        UserContest userContestReturn = userContestRepository.saveAndFlush(userContest);

        //User submission
        UserSubmission userSubmission = new UserSubmission();
        userSubmission.setSubmissionId(userContestReturn.getSubmissionId());
//        userSubmission.setSubmissionStatus(judge0Response.getStatus().getDescription());

        userSubmissionRepository.saveAndFlush(userSubmission);
        return "Result stored";
    }
}
