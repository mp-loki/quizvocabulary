package com.quizvocabulary.dao.logos;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.quizvocabulary.dao.model.BoardPairEntity;
import com.quizvocabulary.data.model.BoardPair;

public interface BoardPairRepository extends PagingAndSortingRepository<BoardPairEntity, UUID> {

	List<BoardPairEntity> findByBoardId(UUID boardId);

	List<BoardPair> findPageByBoardId(UUID boardId, Pageable pageRequest);

}
