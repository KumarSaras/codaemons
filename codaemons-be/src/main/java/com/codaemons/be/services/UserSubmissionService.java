package com.codaemons.be.services;

import com.codaemons.be.models.submission.UserSubmission;
import com.codaemons.be.repository.UserSubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSubmissionService {

    @Autowired
    private UserSubmissionRepository userSubmissionRepository;

    public List<UserSubmission> findAll(){
        return userSubmissionRepository.findAll();
    }

    public UserSubmission create(final UserSubmission userSubmission){
        return userSubmissionRepository.saveAndFlush(userSubmission);
    }
}
