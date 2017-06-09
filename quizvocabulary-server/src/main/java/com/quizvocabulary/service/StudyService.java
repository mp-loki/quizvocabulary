package com.quizvocabulary.service;

import java.util.Optional;
import java.util.UUID;

import com.quizvocabulary.data.model.Board;
import com.quizvocabulary.data.model.Study;

public interface StudyService {

	Optional<Study> getStudy(String profileId, String langName);
	
	Board createBoard(UUID studyId, String boardName) throws BoardCreationException;
}
