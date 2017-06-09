package com.quizvocabulary.dao.logos;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.fasterxml.uuid.NoArgGenerator;
import com.quizvocabulary.dao.AbstractJpaDao;
import com.quizvocabulary.dao.model.LogosEntity;
import com.quizvocabulary.data.model.Logos;

@Component
public class JpaLogosDao extends AbstractJpaDao<LogosEntity, Logos, UUID> implements LogosDao {

	@Autowired
	private LogosRepository logosRepository;

	@Autowired
	private NoArgGenerator uuidGenerator;

	@Override
	protected CrudRepository<LogosEntity, UUID> getCrudRepository() {
		return logosRepository;
	}

	@Override
	protected Class<LogosEntity> getEntityClass() {
		return LogosEntity.class;
	}

	@Override
	public Logos save(Logos logos) {
		LogosEntity entity = logosRepository.findByLanguageIdAndLogos(logos.getLanguageId(), logos.getLogos());
		if (entity != null) {
			return entity.toDto();
		}
		Logos logosTmpl = new Logos(uuidGenerator.generate(), logos.getLanguageId(), logos.getLogos());
		return super.save(logosTmpl);
	}

}
