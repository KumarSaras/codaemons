package com.codaemons.be.services;

import com.codaemons.be.models.submission.UserSubmission;
import com.codaemons.be.models.submission.UserSubmissionRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface SubmissionService {

    public List<UserSubmission> findAll();
    public List<UserSubmission> findBySubmissionID(final int submissionID);
    public String save(final UserSubmissionRequest userSubmissionRequest);
    public String saveSimulation(final UserSubmissionRequest userSubmissionRequest);
}
