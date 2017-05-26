package com.quizvocabulary.service;

import java.util.List;
import java.util.UUID;

import com.quizvocabulary.data.model.BoardPair;
import com.quizvocabulary.data.model.Pair;

public interface PairService {
		
	Pair save(Pair pair);
	
	BoardPair save(UUID boardId, Pair pair);
	
	void removeBoardPair(UUID id);
	
	List<BoardPair> findAll(UUID boardId);
	
	List<BoardPair> find(UUID boardId, int page, int limit);
	
	List<BoardPair> findRandom(UUID boardId, int limit);
	
}
