package com.quizvocabulary.dao.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.quizvocabulary.data.model.Board;
import com.quizvocabulary.data.model.Language;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name="board")
public class BoardEntity extends BaseEntity<Board> {
	
	@Id
	private UUID id;
	
	private String name;
	
	@ManyToOne
	private LanguageEntity language;

	public BoardEntity(Board board) {
		this.id = board.getId();
		this.name = board.getName();
		this.language = new LanguageEntity(board.getLanguage());
	}
	
	@Override
	public Board toDto() {
		Board board = new Board();
		board.setId(id);
		board.setName(name);
		board.setLanguage(language.toDto());
		return board;
	}
}
