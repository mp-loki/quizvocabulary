package com.quizvocabulary.dao.logos;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.quizvocabulary.dao.AbstractJpaDao;
import com.quizvocabulary.dao.model.LogosEntity;
import com.quizvocabulary.data.model.Logos;

@Component
public class JpaLogosDao extends AbstractJpaDao<LogosEntity, Logos, UUID> implements LogosDao {

	@Autowired
	private LogosRepository logosRepository;

	@Override
	protected CrudRepository<LogosEntity, UUID> getCrudRepository() {
		return logosRepository;
	}

	@Override
	protected Class<LogosEntity> getEntityClass() {
		return LogosEntity.class;
	}

}
