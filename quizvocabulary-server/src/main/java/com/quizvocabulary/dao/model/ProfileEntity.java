package com.quizvocabulary.dao.model;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.quizvocabulary.data.model.Profile;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "profile")
public class ProfileEntity implements ToDto<Profile> {

	@Transient
	private static final long serialVersionUID = 5253002666869325360L;

	@Id
	private String id;

	@Column(unique = true)
	private String email;

	@ManyToOne
	private LanguageEntity defaultLanguage;

	@ElementCollection(fetch = FetchType.EAGER)
	private List<LanguageEntity> languages;

	public ProfileEntity(Profile profile) {
		this.id = profile.getId();
		this.email = profile.getEmail();
		this.defaultLanguage = new LanguageEntity(profile.getDefaultLanguage());
		if (profile.getLanguages() != null) {
			this.languages = profile.getLanguages().stream().map(p -> new LanguageEntity(p))
					.collect(Collectors.toList());
		}
	}

	@Override
	public Profile toDto() {
		Profile profile = new Profile();
		profile.setId(id);
		profile.setEmail(email);
		profile.setDefaultLanguage(defaultLanguage.toDto());
		if (languages != null) {
			profile.setLanguages(languages.stream().map(l -> l.toDto()).collect(Collectors.toList()));
		}
		return profile;
	}
}
