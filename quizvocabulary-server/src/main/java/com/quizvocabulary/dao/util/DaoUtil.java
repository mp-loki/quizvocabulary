package com.quizvocabulary.dao.util;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.quizvocabulary.dao.model.BaseEntity;

public class DaoUtil {
	
	public static <T> T toDto(BaseEntity<T> entity) {
		if (entity == null) {
			return null;
		}
		return entity.toDto();
	}
	
	public static <T> List<T> toDtoList(Collection<? extends BaseEntity<T>> entities) {
		return entities.stream().map(BaseEntity::toDto).collect(Collectors.toList());
	}

}
