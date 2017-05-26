package com.quizvocabulary.dao.logos;

import java.util.UUID;

import com.quizvocabulary.dao.Dao;
import com.quizvocabulary.data.model.Pair;

public interface PairDao extends Dao<Pair, UUID> {
	
	Pair findMatchingPair(Pair pair);

}
