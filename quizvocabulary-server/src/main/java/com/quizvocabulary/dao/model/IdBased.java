package com.quizvocabulary.dao.model;

public interface IdBased<T> {
	
	T getId();
	
	void setId(T t);
}
