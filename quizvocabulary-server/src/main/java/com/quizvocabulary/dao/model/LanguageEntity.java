package com.quizvocabulary.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.quizvocabulary.data.model.Language;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class LanguageEntity extends BaseEntity<Language> {
	
	@Id
	@Column
	private String name;
	
	@Column(unique = true)
	private String code;
	
	public LanguageEntity(Language language) {
		this.name = language.getName();
		this.code = language.getCode();
	}

	@Override
	public Language toDto() {
		Language language = new Language();
		language.setName(name);
		language.setCode(code);
		return language;
	}
}
