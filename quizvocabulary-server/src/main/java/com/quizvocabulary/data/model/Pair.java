package com.quizvocabulary.data.model;

import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Pair {

	public Pair(Logos logosA, Logos logosB) {
		this.logosA = logosA;
		this.logosB = logosB;
	}

	public Pair(UUID id, Logos logosA, Logos logosB) {
		this.id = id;
		this.logosA = logosA;
		this.logosB = logosB;
	}

	private UUID id;
	private Logos logosA;
	private Logos logosB;
}
