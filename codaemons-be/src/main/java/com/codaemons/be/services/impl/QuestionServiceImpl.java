package com.codaemons.be.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codaemons.be.dao.IQuestionsRepository;
import com.codaemons.be.models.Questions;
import com.codaemons.be.services.IQuestionService;

@Service
public class QuestionServiceImpl implements IQuestionService {
	
	@Autowired 												//TODO: should we use Inject instead of auto-wired
	private IQuestionsRepository questionsRepository;

	@Override
	public void saveQuestion(Questions question) {
		
		questionsRepository.save(question);
	}
	
	@Override
	public List<Questions> getAllQuestions() {
		
		return questionsRepository.findAll();
	}

	@Override
	public Questions getQuestion(int questionId) {
		
		return questionsRepository.findById(questionId).get(); 
	}

	@Override
	public void deleteQuestion(int questionId) {
		
		questionsRepository.deleteById(questionId);
	}
}
