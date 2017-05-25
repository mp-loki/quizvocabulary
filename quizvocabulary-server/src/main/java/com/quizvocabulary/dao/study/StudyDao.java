package com.quizvocabulary.dao.study;

import java.util.UUID;

import com.quizvocabulary.dao.Dao;
import com.quizvocabulary.data.model.Study;

public interface StudyDao extends Dao<Study, UUID> {
	
	Study findStudyByProfileIdAndLanguageName(String profileId, String languageName);

}
