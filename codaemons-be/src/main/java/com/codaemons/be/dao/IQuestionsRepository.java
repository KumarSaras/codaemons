package com.codaemons.be.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codaemons.be.models.Questions;

@Repository
public interface IQuestionsRepository extends JpaRepository<Questions, Integer>{
}
