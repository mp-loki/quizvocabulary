package com.quizvocabulary.dao.logos;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.quizvocabulary.dao.model.BoardPairEntity;

public interface BoardPairRepository extends PagingAndSortingRepository<BoardPairEntity, UUID> {

	List<BoardPairEntity> findByBoardId(UUID boardId);

	List<BoardPairEntity> findPageByBoardId(UUID boardId, Pageable pageRequest);
	
	@Query(nativeQuery=true, value="SELECT *  FROM board_pair WHERE board_id = ?1 ORDER BY random() LIMIT ?2")
	List<BoardPairEntity> findRandom(UUID boardId, int limit);
}
