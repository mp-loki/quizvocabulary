package com.quizvocabulary.data.model;

import java.util.UUID;

import com.quizvocabulary.dao.model.LanguageEntity;

import lombok.Data;

@Data
public class Logos {

	private UUID id;
	private LanguageEntity language;
	private String logos;

}
