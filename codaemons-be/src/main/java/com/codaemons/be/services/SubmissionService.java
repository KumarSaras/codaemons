package com.codaemons.be.services;

import com.codaemons.be.dao.UserSubmissionRepository;
import com.codaemons.be.models.submission.UserSubmission;
import com.codaemons.be.models.submission.UserSubmissionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubmissionService {

    public List<UserSubmission> findAll();
    public String save(final UserSubmissionRequest userSubmissionRequest);
}
