package com.quizvocabulary.data.model;

import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Logos {

	private UUID id;
	private String languageId;
	private String logos;
	
	public Logos(UUID id, String languageId, String logos) {
		this.id = id;
		this.languageId = languageId;
		this.logos = logos;
	}
	
	public Logos(String languageId, String logos) {
		this.languageId = languageId;
		this.logos = logos;
	}
}
