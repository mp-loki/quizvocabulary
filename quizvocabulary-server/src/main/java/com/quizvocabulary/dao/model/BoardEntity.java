package com.quizvocabulary.dao.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;


public class BoardEntity {
	
	@Id
	private UUID id;
	private String name;
	
}
