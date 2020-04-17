package com.codaemons.be.repository;

import com.codaemons.be.models.submission.UserSubmission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSubmissionRepository extends JpaRepository<UserSubmission, Long> {

}
