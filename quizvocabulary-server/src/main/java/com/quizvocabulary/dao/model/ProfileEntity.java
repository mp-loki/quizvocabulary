package com.quizvocabulary.dao.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.quizvocabulary.data.model.Profile;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name="profile")
public class ProfileEntity extends BaseEntity<Profile> {
	
	@Id
	private String id;
	
	private String email;
	
	@ManyToOne
	private LanguageEntity defaultLanguage;
	
	public ProfileEntity(Profile profile) {
		this.id = profile.getId();
		this.email = profile.getEmail();
		this.defaultLanguage = new LanguageEntity(profile.getDefaultLanguage());
	}
	
	@Override
	public Profile toDto() {
		Profile profile = new Profile();
		profile.setId(id);
		profile.setEmail(email);
		profile.setDefaultLanguage(defaultLanguage.toDto());
		return profile;
	}
}
