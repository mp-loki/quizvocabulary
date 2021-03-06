package com.quizvocabulary.controller;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.quizvocabulary.data.model.Pair;
import com.quizvocabulary.data.model.Study;
import com.quizvocabulary.service.QuizVocabularyServiceException;
import com.quizvocabulary.service.StudyService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class StudyController extends AbstractController {

	@Autowired
	private StudyService studyService;

	@RequestMapping(value = "/study/{langName}", method = RequestMethod.GET)
	public ResponseEntity<?> getStudy(@PathVariable("langName") String langName) {
		Optional<Study> studyOpt = studyService.getStudy(getProfileId(), langName);
		if (studyOpt.isPresent()) {
			return new ResponseEntity<>(studyOpt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
