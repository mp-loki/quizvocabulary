package com.quizvocabulary.dao.model;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.quizvocabulary.data.model.BoardPair;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "board_pair")
public class BoardPairEntity implements ToDto<BoardPair> {

	@Transient
	private static final long serialVersionUID = -3489959472739203253L;

	@Id
	private UUID id;
	
	@Column(name = "board_id")
	private UUID boardId;

	@ManyToOne(cascade = CascadeType.DETACH)
	private PairEntity pair;

	public BoardPairEntity(BoardPair boardPair) {
		this.id = boardPair.getId();
		this.boardId = boardPair.getId();
		this.pair = new PairEntity(boardPair.getPair());
	}

	@Override
	public BoardPair toDto() {
		BoardPair boardPair = new BoardPair();
		boardPair.setId(id);
		boardPair.setBoardId(boardId);
		boardPair.setPair(pair.toDto());
		return boardPair;
	}
}
