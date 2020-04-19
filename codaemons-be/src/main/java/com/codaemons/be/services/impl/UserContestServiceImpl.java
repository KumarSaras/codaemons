package com.codaemons.be.services.impl;

import com.codaemons.be.dao.UserContestRepository;
import com.codaemons.be.models.submission.UserContest;
import com.codaemons.be.services.UserContestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserContestServiceImpl implements UserContestService {

    @Autowired
    private UserContestRepository userContestRepository;

    public List<UserContest> findAll(){
        return userContestRepository.findAll();
    }

    public UserContest save(final UserContest userContest){
        return userContestRepository.saveAndFlush(userContest);
    }
}
