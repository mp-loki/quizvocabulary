package com.quizvocabulary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Optional;
import com.quizvocabulary.dao.language.LanguageDao;
import com.quizvocabulary.data.model.Language;

@Service
public class LanguageServiceImpl implements LanguageService {

	@Autowired
	private LanguageDao languageDao;
	
	@Override
	public List<Language> findAll() {
		return languageDao.findAll();
	}

	@Override
	public Language findByCode(String code) {
		return languageDao.findByCode(code);
	}

	@Override
	public Language findByName(String name) {
		return languageDao.findByName(name);
	}
}
