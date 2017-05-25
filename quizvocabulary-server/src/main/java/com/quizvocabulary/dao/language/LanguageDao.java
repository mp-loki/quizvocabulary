package com.quizvocabulary.dao.language;

import com.quizvocabulary.dao.Dao;
import com.quizvocabulary.data.model.Language;

public interface LanguageDao extends Dao<Language, String> {
	
	Language findByCode(String code);
	Language findByName(String name);
}
