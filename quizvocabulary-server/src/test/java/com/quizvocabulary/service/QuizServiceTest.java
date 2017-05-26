package com.quizvocabulary.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.quizvocabulary.AbstractSpringTest;

public class QuizServiceTest  extends AbstractSpringTest {
	
	@Autowired
	private QuizService quizService;
	
	@Autowired
	private StudyService studyService;

}
