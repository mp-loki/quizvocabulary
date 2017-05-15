package com.quizvocabulary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.quizvocabulary.dao.language.LanguageDao;
import com.quizvocabulary.data.model.Language;

@Component
public class LanguageService {

	@Autowired
	private LanguageDao languageDao;
	
	public List<Language> findAll() {
		return languageDao.findAll();
	}
}
