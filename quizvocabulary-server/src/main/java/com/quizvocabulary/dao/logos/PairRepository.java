package com.quizvocabulary.dao.logos;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.quizvocabulary.dao.model.PairEntity;

public interface PairRepository extends PagingAndSortingRepository<PairEntity, UUID> {
	
}
