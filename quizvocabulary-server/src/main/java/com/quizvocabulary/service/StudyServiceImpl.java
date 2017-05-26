package com.quizvocabulary.service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.uuid.NoArgGenerator;
import com.quizvocabulary.dao.language.LanguageDao;
import com.quizvocabulary.dao.logos.BoardPairDao;
import com.quizvocabulary.dao.logos.PairDao;
import com.quizvocabulary.dao.profile.ProfileDao;
import com.quizvocabulary.dao.study.StudyDao;
import com.quizvocabulary.data.model.Board;
import com.quizvocabulary.data.model.BoardPair;
import com.quizvocabulary.data.model.Language;
import com.quizvocabulary.data.model.Pair;
import com.quizvocabulary.data.model.Profile;
import com.quizvocabulary.data.model.Study;

@Service
public class StudyServiceImpl implements StudyService {

	private static final String DEFAULT = "Default";

	@Autowired
	private ProfileDao profileDao;

	@Autowired
	private StudyDao studyDao;

	@Autowired
	private LanguageDao languageDao;
	
	@Autowired
	private BoardPairDao boardPairDao;
	
	@Autowired
	private PairDao pairDao;

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

	@Override
	public Board createBoard(UUID studyId, String boardName) throws BoardCreationException {
		Study study = studyDao.findById(studyId);
		if (boardName.equals(DEFAULT) || study.getBoards().stream().anyMatch(b -> b.getName().equals(boardName))) {
			throw new BoardCreationException("Board name must be unique within the study");
		}
		Board board = createBoard(studyId, boardName);
		if (study.getBoards() == null) {
			study.setBoards(new ArrayList<>());
		}
		study.getBoards().add(board);
		studyDao.save(study);
		return board;
	}

	@Override
	public BoardPair addPair(UUID boardId, Pair pair) {
		BoardPair boardPair = new BoardPair();
		boardPair.setId(uuidGenerator.generate());
		boardPair.setBoardId(boardId);
		// TODO: complete this method

		
		return null;
	}

	private Study createStudy(Profile profile, String langName) {
		Language languageA = languageDao.findByName(langName);
		Language languageB = profile.getDefaultLanguage();
		Study study = new Study();
		study.setId(uuidGenerator.generate());
		study.setProfileId(profile.getId());
		study.setLanguageA(languageA);
		study.setLanguageB(profile.getDefaultLanguage());

		Board defaultBoard = createBoard(languageA, languageB, DEFAULT);
		study.setDefaultBoard(defaultBoard);
		return studyDao.save(study);
	}

	private Board createBoard(Language languageA, Language languageB, String name) {
		Board board = new Board();
		board.setId(uuidGenerator.generate());
		board.setName(name);
		board.setLanguageA(languageA);
		board.setLanguageB(languageB);
		return board;
	}

}
