package com.quizvocabulary.data.model;

import lombok.Data;

@Data
public class Profile {
	
	private String id;
	private String email;
	private Language defaultLanguage;
}
