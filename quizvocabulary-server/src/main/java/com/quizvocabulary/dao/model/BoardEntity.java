package com.quizvocabulary.dao.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.quizvocabulary.data.model.Board;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name="board")
public class BoardEntity implements ToDto<Board> {
	
	@Transient
	private static final long serialVersionUID = 7592864956966766191L;

	@Id
	private UUID id;
	
	private String name;
	
	@ManyToOne
	private LanguageEntity languageA;
	
	@ManyToOne
	private LanguageEntity languageB;

	public BoardEntity(Board board) {
		this.id = board.getId();
		this.name = board.getName();
		this.languageA = new LanguageEntity(board.getLanguageA());
		this.languageB = new LanguageEntity(board.getLanguageB());
	}
	
	@Override
	public Board toDto() {
		Board board = new Board();
		board.setId(id);
		board.setName(name);
		board.setLanguageA(languageA.toDto());
		board.setLanguageB(languageB.toDto());
		return board;
	}
}
