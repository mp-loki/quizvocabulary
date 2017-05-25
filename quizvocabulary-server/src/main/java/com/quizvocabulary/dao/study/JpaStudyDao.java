package com.quizvocabulary.dao.study;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.quizvocabulary.dao.AbstractJpaDao;
import com.quizvocabulary.dao.model.StudyEntity;
import com.quizvocabulary.data.model.Study;

@Component
public class JpaStudyDao extends AbstractJpaDao<StudyEntity, Study, UUID> implements StudyDao {
	
	@Autowired
	private StudyRepository studyRepository;
	
	@Override
	public Study findStudyByProfileIdAndLanguageName(String profileId, String languageName) {
		return null;
	}

	@Override
	protected CrudRepository<StudyEntity, UUID> getCrudRepository() {
		return studyRepository;
	}

	@Override
	protected Class<StudyEntity> getEntityClass() {
		return StudyEntity.class;
	}

}
