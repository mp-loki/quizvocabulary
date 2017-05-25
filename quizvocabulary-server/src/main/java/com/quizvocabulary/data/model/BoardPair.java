package com.quizvocabulary.data.model;

import java.util.UUID;

import lombok.Data;

@Data
public class BoardPair {
	
	private UUID id;
	private UUID boardId;
	private Pair pair;

}
