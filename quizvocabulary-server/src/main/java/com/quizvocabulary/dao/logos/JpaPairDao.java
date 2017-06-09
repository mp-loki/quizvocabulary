package com.quizvocabulary.dao.logos;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.fasterxml.uuid.NoArgGenerator;
import com.quizvocabulary.dao.AbstractJpaDao;
import com.quizvocabulary.dao.model.PairEntity;
import com.quizvocabulary.data.model.Logos;
import com.quizvocabulary.data.model.Pair;

@Component
public class JpaPairDao extends AbstractJpaDao<PairEntity, Pair, UUID> implements PairDao {

	@Autowired
	private PairRepository pairRepository;

	@Autowired
	private LogosDao logosDao;

	@Autowired
	private NoArgGenerator uuidGenerator;

	@Override
	protected CrudRepository<PairEntity, UUID> getCrudRepository() {
		return pairRepository;
	}

	@Override
	protected Class<PairEntity> getEntityClass() {
		return PairEntity.class;
	}

	@Override
	public Pair save(Pair pair) {
		Pair match = findMatchingPair(pair);
		if (match != null) {
			return match;
		}
		Logos logosA = logosDao.save(pair.getLogosA());
		Logos logosB = logosDao.save(pair.getLogosB());
		Pair pairTmpl = new Pair(uuidGenerator.generate(), logosA, logosB);
		return super.save(pairTmpl);
	}

	@Override
	public Pair findMatchingPair(Pair pair) {
		PairEntity entity = pairRepository.findByLogosA_LogosAndLogosB_Logos(pair.getLogosA().getLogos(), pair.getLogosB().getLogos());
		return entity == null ? null : entity.toDto();
	}

}
