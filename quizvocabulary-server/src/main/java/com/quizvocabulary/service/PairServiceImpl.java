package com.quizvocabulary.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.uuid.NoArgGenerator;
import com.quizvocabulary.dao.logos.BoardPairDao;
import com.quizvocabulary.dao.logos.LogosDao;
import com.quizvocabulary.dao.logos.PairDao;
import com.quizvocabulary.data.model.BoardPair;
import com.quizvocabulary.data.model.Logos;
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
		return pairDao.save(pair);
	}

	@Override
	public BoardPair save(UUID boardId, Pair pair) {

		Pair persistentPair = save(pair);

		BoardPair boardPair = new BoardPair();
		boardPair.setId(uuidGenerator.generate());
		boardPair.setBoardId(boardId);
		boardPair.setPair(persistentPair);

		return boardPairDao.save(boardPair);
	}

	@Override
	public void removeBoardPair(UUID id) {
		boardPairDao.removeById(id);
	}

	@Override
	public List<Pair> findAll(UUID boardId) {
		return mapPairs(boardPairDao.findAllByBoardId(boardId));
	}

	@Override
	public List<Pair> find(UUID boardId, int page, int limit) {
		return mapPairs(boardPairDao.findPageByBoardId(boardId, page, limit));
	}

	@Override
	public List<Pair> findRandom(UUID boardId, int limit) {
		return mapPairs(boardPairDao.findRandom(boardId, limit));
	}

	private List<Pair> mapPairs(List<BoardPair> boardPairs) {
		return boardPairs.stream().map(p -> p.getPair()).collect(Collectors.toList());
	}
}
