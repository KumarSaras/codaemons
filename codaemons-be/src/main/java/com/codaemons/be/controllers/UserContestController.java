package com.codaemons.be.controllers;

import com.codaemons.be.models.submission.UserContest;
import com.codaemons.be.services.UserContestService;
import com.codaemons.be.services.impl.UserContestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/userContest")
public class UserContestController {
    @Autowired
    private UserContestService userContestService;

    @GetMapping
    public List<UserContest> list(){
        return userContestService.findAll();
    }

}
