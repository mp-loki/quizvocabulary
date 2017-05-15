package com.quizvocabulary.dao.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.quizvocabulary.dao.AbstractJpaDao;
import com.quizvocabulary.dao.model.ProfileEntity;
import com.quizvocabulary.data.model.Profile;

@Component
public class JpaProfileDao extends AbstractJpaDao<ProfileEntity, Profile, String> implements ProfileDao {

	@Autowired
	private ProfileRepository profileRepository;
	
	@Override
	protected CrudRepository<ProfileEntity, String> getCrudRepository() {
		return profileRepository;
	}

	@Override
	protected Class<ProfileEntity> getEntityClass() {
		return ProfileEntity.class;
	}
}
