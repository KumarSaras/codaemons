package com.codaemons.be.dao;

import com.codaemons.be.models.submission.UserSubmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSubmissionRepository extends JpaRepository<UserSubmission, Integer> {

}
