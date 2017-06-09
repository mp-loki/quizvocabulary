package com.quizvocabulary.dao.study;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.quizvocabulary.dao.model.StudyEntity;

public interface StudyRepository extends CrudRepository<StudyEntity, UUID> {
	
	StudyEntity findByProfileIdAndLanguageA(String profileId, String languageA);
}
