package com.quizvocabulary.data.model;

import java.util.UUID;

import lombok.Data;

@Data
public class Pair {
	
	private UUID id;
	private Logos logosA;
	private Logos LogosB;
}
