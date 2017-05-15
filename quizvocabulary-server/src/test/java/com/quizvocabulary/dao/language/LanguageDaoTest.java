package com.quizvocabulary.dao.language;


import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.quizvocabulary.QuizvocabularyApplicationTests;
import com.quizvocabulary.data.model.Language;

public class LanguageDaoTest extends QuizvocabularyApplicationTests {

	@Autowired
	private LanguageDao languageDao;
	
	@Ignore
	@Test
	public void testSave() {
		Language language = new Language();
		language.setName("English");
		language.setCode("en");
		languageDao.save(language);
		language.setName("Deutsch");
		language.setCode("de");
		languageDao.save(language);
		language.setName("Français");
		language.setCode("fr");
		languageDao.save(language);
		language.setName("Italiano");
		language.setCode("it");
		languageDao.save(language);
		language.setName("Español");
		language.setCode("es");
		languageDao.save(language);
		language.setName("Українська");
		language.setCode("ua");
		languageDao.save(language);
		language.setName("日本語");
		language.setCode("jp");
		languageDao.save(language);
	}
}
