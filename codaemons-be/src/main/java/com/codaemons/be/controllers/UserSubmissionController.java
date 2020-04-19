package com.codaemons.be.controllers;

import com.codaemons.be.models.submission.Judge0Response;
import com.codaemons.be.models.submission.UserSubmission;
import com.codaemons.be.models.submission.Judge0Request;
import com.codaemons.be.models.submission.UserSubmissionRequest;
import com.codaemons.be.services.SubmissionService;
import com.codaemons.be.services.impl.SubmissionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/v1/userSubmission")
public class UserSubmissionController {

    @Autowired
    private SubmissionServiceImpl submissionService;


    @PostMapping
    public String createSubmission(@RequestBody final UserSubmissionRequest userSubmissionRequest){
        return submissionService.save(userSubmissionRequest);
    }

    @GetMapping
    public List<UserSubmission> findAll(){
        return submissionService.findAll();
    }
}
