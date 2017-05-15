package com.quizvocabulary.data.model;

import lombok.Data;

@Data
public class Study {
	
	private Language language;
	private String name;
	private Profile profile;
}
