package com.quizvocabulary.dao.study;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.quizvocabulary.dao.model.StudyEntity;

public interface StudyRepository extends CrudRepository<StudyEntity, UUID> {
	
	StudyEntity findByProfileIdAndLanguageName(String profileId, String languageName);
}
