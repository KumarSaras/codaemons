package com.codaemons.be.dao;

import com.codaemons.be.models.submission.UserContest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserContestRepository extends JpaRepository<UserContest, Integer > {

}
