package com.quizvocabulary.data.model;

import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class Study {

	private UUID id;
	
	private Language languageA;
	
	private Language languageB;

	private String profileId;

	private Board defaultBoard;

	private List<Board> boards;
}
