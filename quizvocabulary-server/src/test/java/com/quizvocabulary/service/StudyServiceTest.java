package com.quizvocabulary.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.quizvocabulary.AbstractSpringTest;
import com.quizvocabulary.data.model.Language;
import com.quizvocabulary.data.model.Profile;
import com.quizvocabulary.data.model.Study;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudyServiceTest extends AbstractSpringTest {
	
	@Autowired
	private StudyService studyService;
	
	@Autowired
	private ProfileService profileService;
	
	@Test
	public void testGetStudy() {
		Profile profile = setupProfile();
		Optional<Study> studyOpt1 = studyService.getStudy(profile.getId(), "Deutsch");
		assertTrue("Optional is expected to contain a value", studyOpt1.isPresent());
		
		Optional<Study> studyOpt2 = studyService.getStudy(profile.getId(), "Italiano");
		assertFalse("Optional is expected to be empty", studyOpt2.isPresent());
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
