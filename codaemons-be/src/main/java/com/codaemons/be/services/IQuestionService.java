package com.codaemons.be.services;

import java.util.List;

import com.codaemons.be.models.Questions;

public interface IQuestionService {

	void saveQuestion(Questions question);

	List<Questions> getAllQuestions();
	
	Questions getQuestion(int questionId);
	
	void deleteQuestion(int questionId);
}
