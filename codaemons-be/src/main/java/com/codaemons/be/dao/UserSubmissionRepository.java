package com.codaemons.be.dao;

import com.codaemons.be.models.submission.UserSubmission;
import com.codaemons.be.models.submission.UserSubmissionKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserSubmissionRepository extends JpaRepository<UserSubmission, UserSubmissionKey> {

    List<UserSubmission> findBySubmissionId(int submissionId);
}
