package com.codaemons.be.services;

import java.util.List;

import com.codaemons.be.models.Questions;

public interface IQuestionService {

	List<Questions> getAllQuestions();
	
	void saveQuestion(Questions question);
}
