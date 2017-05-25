package com.quizvocabulary.dao.model;

import java.io.Serializable;

public interface ToDto<T> extends Serializable {
	
	T toDto();

}
