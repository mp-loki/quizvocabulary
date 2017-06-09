package com.quizvocabulary.controller;

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
import com.quizvocabulary.service.PairService;
import com.quizvocabulary.service.QuizVocabularyServiceException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class PairController {
	
	@Autowired
	private PairService pairService;
	
	@RequestMapping(value = "/pairs/{boardId}", method = RequestMethod.POST)
	public ResponseEntity<?> addPair(@PathVariable("boardId") String boardId, @RequestBody Pair pair) {
		log.info("*** POST /pairs/{} called", boardId);
		try {
			pairService.save(UUID.fromString(boardId), pair);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (QuizVocabularyServiceException e) {
			log.error(e.getMessage(), e);
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
