package com.codaemons.be.controllers;

import com.codaemons.be.models.submission.Judge0Response;
import com.codaemons.be.models.submission.UserSubmission;
import com.codaemons.be.models.submission.Judge0Request;
import com.codaemons.be.models.submission.UserSubmissionRequest;
import com.codaemons.be.services.UserSubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/v1/userSubmission")
public class UserSubmissionController {

    @Autowired
    private UserSubmissionService userSubmissionService;

    @Value("${judge0.submissions.uri}")
    private String judge0SubmissionURI;

    @GetMapping
    public List<UserSubmission> list(){
        return userSubmissionService.findAll();
    }
    @PostMapping
    public Judge0Response createSubmission(@RequestBody final UserSubmissionRequest userSubmissionRequest){

      //  String sourceCode = "public class Main {public static void main(String[] args) {System.out.println(\\\"Hello World\\\");}}";
        Judge0Request judge0Request = new Judge0Request(userSubmissionRequest.getSourceCode(),
                                                        userSubmissionRequest.getLanguageId(),
                                                                                     "");
//        call for create submission
        RestTemplate restTemplate = new RestTemplate();
        Judge0Response judge0Response = restTemplate.postForObject(judge0SubmissionURI, judge0Request, Judge0Response.class);
      //  return userSubmissionService.create(userSubmission);
        return judge0Response;
    }
}
