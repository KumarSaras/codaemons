package com.codaemons.be.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codaemons.be.models.submission.UserContest;
import com.codaemons.be.services.UserContestService;

@RestController
@RequestMapping("/userContest")
public class UserContestController {
    @Autowired
    private UserContestService userContestService;

    @GetMapping
    public List<UserContest> list(){
        return userContestService.findAll();
    }

}
