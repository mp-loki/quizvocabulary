package com.quizvocabulary.service;

import com.quizvocabulary.data.model.Profile;

public interface ProfileService {

	 Profile getProfile(String id);
	 
	 Profile saveOrUpdateProfile(Profile profile);
}
