package com.codaemons.be.dao;

import com.codaemons.be.models.submission.UserSubmission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSubmissionRepository extends JpaRepository<UserSubmission, Long> {

}
