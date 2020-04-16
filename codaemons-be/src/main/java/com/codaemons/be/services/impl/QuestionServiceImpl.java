package com.codaemons.be.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.codaemons.be.dao.IQuestionsRepository;
import com.codaemons.be.models.Questions;
import com.codaemons.be.services.IQuestionService;

public class QuestionServiceImpl implements IQuestionService {
	
	@Autowired 												//TODO: should we used Inject instead of auto-wired
	private IQuestionsRepository questionsRepository;

	@Override
	public List<Questions> getAllQuestions() {
		
		return questionsRepository.findAll();
	}

	@Override
	public void saveQuestion(Questions question) {
		
		questionsRepository.save(question);
	}
}
