package com.quizvocabulary.dao.logos;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.quizvocabulary.dao.model.LogosEntity;

public interface LogosRepository extends CrudRepository<LogosEntity, UUID> {

}
