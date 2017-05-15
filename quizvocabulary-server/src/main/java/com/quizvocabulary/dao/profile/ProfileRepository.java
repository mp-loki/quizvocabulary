package com.quizvocabulary.dao.profile;

import org.springframework.data.repository.CrudRepository;

import com.quizvocabulary.dao.model.ProfileEntity;

public interface ProfileRepository extends CrudRepository<ProfileEntity, String> {

}
