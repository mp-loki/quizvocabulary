package com.quizvocabulary.service;

public class QuizVocabularyServiceException extends RuntimeException {

	private static final long serialVersionUID = -4486579203850370028L;

	public QuizVocabularyServiceException() {
		super();
	}

	public QuizVocabularyServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public QuizVocabularyServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public QuizVocabularyServiceException(String message) {
		super(message);
	}

	public QuizVocabularyServiceException(Throwable cause) {
		super(cause);
	}
}
