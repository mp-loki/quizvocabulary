package com.quizvocabulary.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.quizvocabulary.dao.logos.BoardPairDao;
import com.quizvocabulary.data.model.BoardPair;
import com.quizvocabulary.data.model.Logos;
import com.quizvocabulary.data.model.Pair;
import com.quizvocabulary.data.model.quiz.Quiz;
import com.quizvocabulary.data.model.quiz.QuizEntry;

@Service
public class QuizServiceImpl implements QuizService {

	private static final int MULTIPLE_CHOICE_SIZE = 4;
	@Autowired
	private BoardPairDao boardPairDao;

	@Override
	public Quiz getQuiz(UUID boardId) {
		List<BoardPair> pairs = boardPairDao.findAllByBoardId(boardId);
		return createDirectQuiz(pairs);
	}

	@Override
	public Quiz getQuiz(UUID boardId, int page, int limit) {
		List<BoardPair> pairs = boardPairDao.findPageByBoardId(boardId, page, limit);
		return createDirectQuiz(pairs);
	}

	@Override
	public Quiz getRandomQuiz(UUID boardId, int limit) {
		List<BoardPair> pairs = boardPairDao.findRandom(boardId, limit);
		return createDirectQuiz(pairs);
	}
	
	@Override
	public Quiz getReverseQuiz(UUID boardId) {
		List<BoardPair> pairs = boardPairDao.findAllByBoardId(boardId);
		return createReverseQuiz(pairs);
	}

	@Override
	public Quiz getReverseQuiz(UUID boardId, int page, int limit) {
		List<BoardPair> pairs = boardPairDao.findPageByBoardId(boardId, page, limit);
		return createReverseQuiz(pairs);
	}
	
	@Override
	public Quiz getRandomReverseQuiz(UUID boardId, int limit) {
		List<BoardPair> pairs = boardPairDao.findRandom(boardId, limit);
		return createReverseQuiz(pairs);
	}
	
	private Quiz createDirectQuiz(List<BoardPair> pairs) {
		return createQuiz(pairs, Pair::getLogosA, Pair::getLogosB);
	}
	
	private Quiz createReverseQuiz(List<BoardPair> pairs) {
		return createQuiz(pairs, Pair::getLogosB, Pair::getLogosA);
	}

	private Quiz createQuiz(List<BoardPair> pairs, Function<Pair, Logos> getQuestionFunction, Function<Pair, Logos> getAnswerFunction) {
		Quiz quiz = new Quiz();
		List<QuizEntry> quizEntries = new ArrayList<>(pairs.size());

		for (int i = 0; i < pairs.size(); i++) {
			QuizEntry entry = new QuizEntry();
			BoardPair pair = pairs.get(i);
			entry.setQuestion(getQuestionFunction.apply(pair.getPair()));
			Logos answer = getAnswerFunction.apply((pair.getPair())); 
			entry.setAnswer(answer);
			List<Logos> answerOptions = getAnswerOptions(pairs, getAnswerFunction, answer, i);
			entry.setOptions(answerOptions);
			quizEntries.add(entry);
			
		}
		quiz.setEntries(quizEntries);
		return quiz;
	}
	private List<Logos> getAnswerOptions(List<BoardPair> pairs, Function<Pair, Logos> getAnswerFunction, Logos correctAnswer, int correctAnswerIdx) {
		List<Logos> answerOptions = new ArrayList<>(MULTIPLE_CHOICE_SIZE);
		answerOptions.add(correctAnswer);
		
		for (int j = 0; j < MULTIPLE_CHOICE_SIZE - 1; j++) {
			BoardPair optionPair = pairs.get(getRandomExcluding(0, pairs.size(), correctAnswerIdx));
			Logos option = getAnswerFunction.apply(optionPair.getPair());
			answerOptions.add(option);
		}
		return answerOptions;
	} 
	
	private int getRandomExcluding(int min, int max, int exclusion) {
		int result = exclusion;
		while (result == exclusion) {
			Random rn = new Random();
			int n = max - min + 1;
			int i = rn.nextInt() % n;
			result = min + i;
		}
		return result;
	}
}
