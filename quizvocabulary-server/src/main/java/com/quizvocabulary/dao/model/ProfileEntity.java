package com.quizvocabulary.dao.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.quizvocabulary.data.model.Profile;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class ProfileEntity extends BaseEntity<Profile> {
	
	@Id
	private String id;
	
	@ManyToOne
	private LanguageEntity defaultLanguage;
	
	public ProfileEntity(Profile profile) {
		this.id = profile.getId();
		this.defaultLanguage = new LanguageEntity(profile.getDefaultLanguage());
	}
	
	@Override
	public Profile toDto() {
		Profile profile = new Profile();
		profile.setId(id);
		profile.setDefaultLanguage(defaultLanguage.toDto());
		return profile;
	}
}
