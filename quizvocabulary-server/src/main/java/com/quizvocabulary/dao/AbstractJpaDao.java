package com.quizvocabulary.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.google.common.collect.Lists;
import com.quizvocabulary.dao.model.BaseEntity;
import com.quizvocabulary.dao.util.DaoUtil;

public abstract class AbstractJpaDao<E extends BaseEntity<T>, T, ID extends Serializable> implements Dao<T, ID>	{
	
	protected abstract CrudRepository<E, ID> getCrudRepository();
	protected abstract Class<E> getEntityClass();
	
	@Override
	public List<T> findAll() {
		return DaoUtil.toDtoList(Lists.newArrayList(getCrudRepository().findAll()));
	}

	@Override
	public T findById(ID id) {
		return DaoUtil.toDto(getCrudRepository().findOne(id));
	}

	@Override
	public T save(T domain) {
		E entity;
		try {
            entity = getEntityClass().getConstructor(domain.getClass()).newInstance(domain);
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format("Unable to create entity for domain object: %s", domain, e));
        }
        entity = getCrudRepository().save(entity);
        return DaoUtil.toDto(entity);
	}

	@Override
	public boolean removeById(ID id) {
		getCrudRepository().delete(id);
        return getCrudRepository().findOne(id) == null;
	}
}
