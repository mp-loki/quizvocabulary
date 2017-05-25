package com.quizvocabulary.dao.language;

import org.springframework.data.repository.CrudRepository;

import com.quizvocabulary.dao.model.LanguageEntity;

public interface LanguageRepository extends CrudRepository<LanguageEntity, String> {
	
	LanguageEntity findByCode(String code);

	LanguageEntity findByName(String name);
}
