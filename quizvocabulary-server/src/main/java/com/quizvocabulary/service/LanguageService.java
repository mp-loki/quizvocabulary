package com.quizvocabulary.service;

import java.util.List;

import com.quizvocabulary.data.model.Language;

public interface LanguageService {

	List<Language> findAll();

	Language findByCode(String code);

	Language findByName(String name);

}
