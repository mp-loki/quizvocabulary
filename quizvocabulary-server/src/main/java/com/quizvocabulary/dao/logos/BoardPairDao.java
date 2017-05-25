package com.quizvocabulary.dao.logos;

import java.util.List;
import java.util.UUID;

import com.quizvocabulary.dao.Dao;
import com.quizvocabulary.data.model.BoardPair;

public interface BoardPairDao extends Dao<BoardPair, UUID> {

	List<BoardPair> findAllByBoardId(UUID boardId);
	
	List<BoardPair> findPageByBoardId(UUID boardId, int page, int limit);

}
