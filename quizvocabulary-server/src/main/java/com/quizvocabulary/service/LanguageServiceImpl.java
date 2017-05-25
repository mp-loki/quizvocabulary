package com.quizvocabulary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.quizvocabulary.dao.language.LanguageDao;
import com.quizvocabulary.data.model.Language;

@Component
public class LanguageServiceImpl implements LanguageService {

	@Autowired
	private LanguageDao languageDao;
	
	@Override
	public List<Language> findAll() {
		return languageDao.findAll();
	}
}
