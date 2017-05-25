package com.quizvocabulary.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.uuid.NoArgGenerator;
import com.quizvocabulary.dao.language.LanguageDao;
import com.quizvocabulary.dao.profile.ProfileDao;
import com.quizvocabulary.dao.study.StudyDao;
import com.quizvocabulary.data.model.Board;
import com.quizvocabulary.data.model.Language;
import com.quizvocabulary.data.model.Profile;
import com.quizvocabulary.data.model.Study;

@Component
public class StudyServiceImpl implements StudyService {

	@Autowired
	private ProfileDao profileDao; 

	@Autowired
	private StudyDao studyDao; 
	
	@Autowired
	private LanguageDao languageDao;
	
	@Autowired
	private NoArgGenerator uuidGenerator;
	
	@Override
	public Optional<Study> getStudy(String profileId, String langName) {
		Profile profile = profileDao.findById(profileId);
		if (profile != null && profile.getLanguages().stream().anyMatch(l -> l.getName().equals(langName))) {
			Study study = studyDao.findStudyByProfileIdAndLanguageName(profileId, langName);
			if (study != null) {
				return Optional.of(study);
			}
			return Optional.of(createStudy(profile, langName));
		}
		return Optional.empty();
	}
	
	private Study createStudy(Profile profile, String langName) {
		
		Language language = languageDao.findByName(langName);
		Study study = new Study();
		study.setId(uuidGenerator.generate());
		study.setProfileId(profile.getId());
		study.setLanguage(language);
		study.setProfileLanguage(profile.getDefaultLanguage());
		
		Board defaultBoard = new Board();
		defaultBoard.setId(uuidGenerator.generate());
		defaultBoard.setName("Default");
		defaultBoard.setLanguage(language);
		
		study.setDefaultBoard(defaultBoard);
		return studyDao.save(study);
	}
}
