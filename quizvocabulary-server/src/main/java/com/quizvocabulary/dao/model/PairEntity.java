package com.quizvocabulary.dao.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.quizvocabulary.data.model.Pair;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name="pair")
public class PairEntity implements ToDto<Pair> {
	
	@Transient
	private static final long serialVersionUID = -4199621787498020294L;

	@Id
	private UUID id;
	@ManyToOne
	private LogosEntity logosA;
	@ManyToOne
	private LogosEntity logosB;

	public PairEntity(Pair pair) {
		this.id = pair.getId();
		this.logosA = new LogosEntity(pair.getLogosA());
		this.logosB = new LogosEntity(pair.getLogosB());
	}
	
	@Override
	public Pair toDto() {
		Pair pair = new Pair();
		pair.setId(id);
		pair.setLogosA(logosA.toDto());
		pair.setLogosB(logosB.toDto());
		return pair;
	}
}
