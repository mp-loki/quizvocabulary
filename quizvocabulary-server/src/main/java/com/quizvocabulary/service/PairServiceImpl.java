package com.quizvocabulary.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.uuid.NoArgGenerator;
import com.quizvocabulary.dao.logos.BoardPairDao;
import com.quizvocabulary.dao.logos.PairDao;
import com.quizvocabulary.data.model.BoardPair;
import com.quizvocabulary.data.model.Pair;

@Service
public class PairServiceImpl implements PairService {

	@Autowired
	private NoArgGenerator uuidGenerator;
	
	@Autowired
	private PairDao pairDao;
	
	@Autowired
	private BoardPairDao boardPairDao;
	
	@Override
	public Pair save(Pair pair) {
		validatePairId(pair);
		return pairDao.save(pair);
	}
	
	@Override
	public BoardPair save(UUID boardId, Pair pair) {
		validatePairId(pair);
		BoardPair boardPair = new BoardPair();
		boardPair.setId(uuidGenerator.generate());
		boardPair.setBoardId(boardId);
		boardPair.setPair(pair);
		return boardPairDao.save(boardPair);
	}
	
	private void validatePairId(Pair pair) {
		if (pair.getId() == null) {
			pair.setId(uuidGenerator.generate());
		}
	} 
	
	@Override
	public void removeBoardPair(UUID id) {
		boardPairDao.removeById(id);
	}

	@Override
	public List<BoardPair> findAll(UUID boardId) {
		return boardPairDao.findAllByBoardId(boardId);
	}

	@Override
	public List<BoardPair> find(UUID boardId, int page, int limit) {
		return boardPairDao.findPageByBoardId(boardId, page, limit);
	}

	@Override
	public List<BoardPair> findRandom(UUID boardId, int limit) {
		return boardPairDao.findRandom(boardId, limit);
	}
}
