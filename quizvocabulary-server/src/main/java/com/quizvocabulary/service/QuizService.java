package com.quizvocabulary.service;

import java.util.UUID;

import com.quizvocabulary.data.model.quiz.Quiz;

public interface QuizService {

	Quiz getQuiz(UUID boardId);
	
	Quiz getQuiz(UUID boardId, int page, int limit);
	
	Quiz getReverseQuiz(UUID boardId);
	
	Quiz getReverseQuiz(UUID boardId, int page, int limit);
	
	Quiz getRandomQuiz(UUID boardId, int limit);

	Quiz getRandomReverseQuiz(UUID boardId, int limit);
}
