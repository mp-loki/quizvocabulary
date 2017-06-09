package com.quizvocabulary.data.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Language {
	
	public Language(String name, String code) {
		this.name = name;
		this.code = code;
	}
	
	private String name;
	private String code;
	
}
