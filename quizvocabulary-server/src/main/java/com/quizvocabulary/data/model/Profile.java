package com.quizvocabulary.data.model;

import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class Profile {
	
	private String id;
	private String email;
	private Language defaultLanguage;
	private List<Language> languages;
}
