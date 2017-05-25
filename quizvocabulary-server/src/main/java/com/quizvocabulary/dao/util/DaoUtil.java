package com.quizvocabulary.dao.util;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.quizvocabulary.dao.model.ToDto;

public class DaoUtil {
	
	public static <T> T toDto(ToDto<T> entity) {
		if (entity == null) {
			return null;
		}
		return entity.toDto();
	}
	
	public static <T> List<T> toDtoList(Collection<? extends ToDto<T>> entities) {
		return entities.stream().map(ToDto::toDto).collect(Collectors.toList());
	}

}
