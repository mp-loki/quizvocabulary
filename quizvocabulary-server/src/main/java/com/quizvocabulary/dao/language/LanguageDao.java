package com.quizvocabulary.dao.language;

import com.quizvocabulary.dao.Dao;
import com.quizvocabulary.model.data.Language;

public interface LanguageDao extends Dao<Language, String> {
	
	Language findByCode(String code);
}
