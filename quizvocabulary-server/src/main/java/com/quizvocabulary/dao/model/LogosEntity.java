package com.quizvocabulary.dao.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.quizvocabulary.data.model.Logos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name="logos")
public class LogosEntity implements ToDto<Logos> {
	
	@Transient
	private static final long serialVersionUID = -2340423417495195623L;

	@Id
	private UUID id;
	
	private String languageId;
	
	private String logos;
	
	public LogosEntity(Logos logos) {
		this.id = logos.getId();
		this.languageId = logos.getLanguageId();
		this.logos = logos.getLogos();
	}
	
	@Override
	public Logos toDto() {
		Logos logos = new Logos();
		logos.setId(this.id);
		logos.setLanguageId(languageId);
		logos.setLogos(this.logos);
		return logos;
	}

}
