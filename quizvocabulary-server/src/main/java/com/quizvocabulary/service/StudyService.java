package com.quizvocabulary.service;

import java.util.Optional;

import com.quizvocabulary.data.model.Study;

public interface StudyService {

	Optional<Study> getStudy(String profileId, String langName);

}
