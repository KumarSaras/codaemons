package com.codaemons.be.controllers;

import com.codaemons.be.models.submission.UserSubmission;
import com.codaemons.be.models.submission.UserSubmissionRequest;
import com.codaemons.be.services.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/userSubmission")
public class UserSubmissionController {

    @Autowired
    private SubmissionService submissionService;


    @PostMapping
    public String createSubmission(@RequestBody final UserSubmissionRequest userSubmissionRequest){
        return submissionService.save(userSubmissionRequest);
    }

    @PostMapping
    @RequestMapping("/test")
    public String createSubmissionSimulation(@RequestBody final UserSubmissionRequest userSubmissionRequest){
        return submissionService.saveSimulation(userSubmissionRequest);
    }

    @GetMapping
    public List<UserSubmission> findAll(){
        return submissionService.findAll();
    }

    @GetMapping("/{submissionID}")
    public Optional<UserSubmission> findBySubmissionId(@PathVariable int submissionID ){
        return submissionService.findBySubmissionID(submissionID);
    }
}
