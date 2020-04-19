package com.codaemons.be.services;

import com.codaemons.be.models.submission.UserContest;

import java.util.List;

public interface UserContestService {

    public List<UserContest> findAll();
    public UserContest save(final UserContest userContest);
}
