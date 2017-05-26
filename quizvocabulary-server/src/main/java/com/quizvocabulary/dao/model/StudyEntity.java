package com.quizvocabulary.dao.model;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.quizvocabulary.data.model.Study;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "study")
public class StudyEntity implements ToDto<Study> {

	@Transient
	private static final long serialVersionUID = 7345835054999934390L;

	@Id
	private UUID id;

	@ManyToOne
	private LanguageEntity languageA;

	@ManyToOne
	private LanguageEntity languageB;
	
	@OneToOne(cascade=CascadeType.ALL)
	private BoardEntity defaultBoard;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private List<BoardEntity> boards;

	@Column(nullable = false)
	private String profileId;

	public StudyEntity(Study study) {
		this.id = study.getId();
		this.languageA = new LanguageEntity(study.getLanguageA());
		this.languageB = new LanguageEntity(study.getLanguageB());
		this.profileId = study.getProfileId();
		this.defaultBoard = new BoardEntity(study.getDefaultBoard());
	}

	@Override
	public Study toDto() {
		Study study = new Study();
		study.setId(id);
		study.setProfileId(profileId);
		study.setLanguageA(languageA.toDto());
		study.setLanguageB(languageB.toDto());
		study.setDefaultBoard(defaultBoard.toDto());
		return study;
	}
}
