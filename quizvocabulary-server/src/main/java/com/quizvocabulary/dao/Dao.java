package com.quizvocabulary.dao;

import java.util.List;

public interface Dao<T, ID> {
	
	List<T> findAll();
	
	T findById(ID id);
	
	T save(T t);
	
	boolean removeById(ID id);
}
