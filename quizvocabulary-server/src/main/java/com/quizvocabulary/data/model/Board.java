package com.quizvocabulary.data.model;

import java.util.UUID;

import lombok.Data;

@Data
public class Board {
	
	private UUID id;
	
	private String name;
	
	private Language languageA;
	private Language languageB;
}
