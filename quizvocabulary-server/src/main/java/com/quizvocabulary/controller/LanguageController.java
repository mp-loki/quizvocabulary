package com.quizvocabulary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.quizvocabulary.data.model.Language;
import com.quizvocabulary.service.LanguageService;

@RestController
@RequestMapping("/api/v1")
public class LanguageController {

	@Autowired
	private LanguageService languageService;

	@RequestMapping(value = "/languages", method = RequestMethod.GET)
	public @ResponseBody List<Language> findAll() {
		return languageService.findAll();
	}

}
