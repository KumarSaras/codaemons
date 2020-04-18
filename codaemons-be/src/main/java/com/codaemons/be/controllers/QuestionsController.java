package com.codaemons.be.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codaemons.be.models.Questions;
import com.codaemons.be.services.IQuestionService;

@RestController
@RequestMapping("/questions")
public class QuestionsController {

	@Autowired
	private IQuestionService questionService;
	
	@PostMapping("")
	public void saveQuestion(@RequestBody Questions question) {
		
		questionService.saveQuestion(question);		
	}
	
	@GetMapping("")
	public List<Questions> getAllQuestions() {
		
		return questionService.getAllQuestions();
	}
	
	@GetMapping("/{questionId}")
	public Questions getQuestion(@PathVariable int questionId) {
		
		return questionService.getQuestion(questionId);
	}
	
	@DeleteMapping("/{questionId}")
	public void deleteQuestion(@PathVariable int questionId) {
		
		questionService.deleteQuestion(questionId);
	}
}
