package com.quizvocabulary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.quizvocabulary.dao.profile.ProfileDao;
import com.quizvocabulary.data.model.Profile;

@Component
public class ProfileService {

	@Autowired
	private ProfileDao profileDao;
	
	public Profile getProfile(String id) {
		return profileDao.findById(id);
	}
}
