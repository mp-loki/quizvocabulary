package com.quizvocabulary.dao.logos;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.quizvocabulary.dao.AbstractJpaDao;
import com.quizvocabulary.dao.model.PairEntity;
import com.quizvocabulary.data.model.Pair;

@Component
public class JpaPairDao extends AbstractJpaDao<PairEntity, Pair, UUID> implements PairDao {

	@Autowired
	private PairRepository pairRepository;
	
	@Override
	protected CrudRepository<PairEntity, UUID> getCrudRepository() {
		return pairRepository;
	}

	@Override
	protected Class<PairEntity> getEntityClass() {
		return PairEntity.class;
	}

	@Override
	public Pair findMatchingPair(Pair pair) {
		// TODO Auto-generated method stub
		return null;
	}

}
