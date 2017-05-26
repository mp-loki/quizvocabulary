package com.quizvocabulary.dao.logos;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.quizvocabulary.dao.AbstractJpaDao;
import com.quizvocabulary.dao.model.BoardPairEntity;
import com.quizvocabulary.dao.util.DaoUtil;
import com.quizvocabulary.data.model.BoardPair;

@Component
public class JpaBoardPairDao extends AbstractJpaDao<BoardPairEntity, BoardPair, UUID> implements BoardPairDao {

	@Autowired
	private BoardPairRepository boardPairRepository;

	@Override
	protected CrudRepository<BoardPairEntity, UUID> getCrudRepository() {
		return boardPairRepository;
	}

	@Override
	protected Class<BoardPairEntity> getEntityClass() {
		return BoardPairEntity.class;
	}

	@Override
	public List<BoardPair> findAllByBoardId(UUID boardId) {
		return DaoUtil.toDtoList(boardPairRepository.findByBoardId(boardId));
	}

	@Override
	public List<BoardPair> findPageByBoardId(UUID boardId, int page, int limit) {
		PageRequest pageRequest = new PageRequest(page, limit, new Sort(Direction.DESC, "id"));
		return DaoUtil.toDtoList(boardPairRepository.findPageByBoardId(boardId, pageRequest));
	}

	@Override
	public List<BoardPair> findRandom(UUID boardId, int limit) {
		return DaoUtil.toDtoList(boardPairRepository.findRandom(boardId, limit));
	}

}
