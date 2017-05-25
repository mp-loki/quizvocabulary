package com.quizvocabulary.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.quizvocabulary.data.model.Language;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name="language")
public class LanguageEntity implements ToDto<Language> {
	
	@Transient
	private static final long serialVersionUID = -3684572739343966208L;

	@Id
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
