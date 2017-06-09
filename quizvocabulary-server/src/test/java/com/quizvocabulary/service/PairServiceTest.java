package com.quizvocabulary.service;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.quizvocabulary.AbstractSpringTest;
import com.quizvocabulary.data.model.Language;
import com.quizvocabulary.data.model.Logos;
import com.quizvocabulary.data.model.Pair;
import com.quizvocabulary.data.model.Profile;
import com.quizvocabulary.data.model.Study;

import static org.junit.Assert.*;

public class PairServiceTest extends AbstractSpringTest {

	@Autowired
	private PairService pairService;

	@Autowired
	private StudyService studyService;

	@Autowired
	private ProfileService profileService;

	@Autowired
	private LanguageService languageService;

	@Test
	public void testSavePairs() {
		Profile profile = setupProfile();
		Optional<Study> frenchOpt = studyService.getStudy(profile.getId(), "Français");
		assertTrue("Optional is expected to contain a value", frenchOpt.isPresent());

		Study frenchStudy = frenchOpt.get();
		UUID defaultBoardId = frenchStudy.getDefaultBoard().getId();

		Language languageA = languageService.findByCode("fr");
		Language languageB = profile.getDefaultLanguage();

		Logos logosA = new Logos("Français", "faire");
		Logos logosB = new Logos("English", "to do");

		Pair pair = new Pair(logosA, logosB);

		pairService.save(defaultBoardId, pair);

		List<Pair> pairs = pairService.findAll(defaultBoardId);
		assertNotNull(pairs);
		assertEquals(1, pairs.size());
		assertEquals("faire", pairs.get(0).getLogosA().getLogos());
		assertEquals("to do", pairs.get(0).getLogosB().getLogos());
	}

	private Profile setupProfile() {
		Profile profile = new Profile();
		profile.setId("TEST_PROFILE");
		profile.setEmail("test@quizvocabulary.io");

		Language defaultLanguage = new Language();
		defaultLanguage.setName("English");
		defaultLanguage.setCode("en");

		List<Language> languages = new ArrayList<>();
		Language de = new Language();
		de.setName("Deutsch");
		de.setCode("de");

		Language fr = new Language();
		fr.setName("Français");
		fr.setCode("fr");
		languages.add(de);
		languages.add(fr);

		profile.setDefaultLanguage(defaultLanguage);
		profile.setLanguages(languages);

		return profileService.saveOrUpdateProfile(profile);
	}

}
