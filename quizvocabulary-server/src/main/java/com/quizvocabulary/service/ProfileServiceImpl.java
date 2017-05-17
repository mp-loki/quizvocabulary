package com.quizvocabulary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.quizvocabulary.dao.profile.ProfileDao;
import com.quizvocabulary.data.model.Profile;

@Component
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private ProfileDao profileDao;
	
	@Override
	public Profile getProfile(String id) {
		return profileDao.findById(id);
	}
	
	@Override
	public Profile saveOrUpdateProfile(Profile profile) {
		return profileDao.save(profile);
	}
}
