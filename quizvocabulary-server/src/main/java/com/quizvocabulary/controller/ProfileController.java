package com.quizvocabulary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.quizvocabulary.data.model.Profile;
import com.quizvocabulary.service.ProfileService;

@RestController
@RequestMapping("/api/v1/")
public class ProfileController extends AbstractController {
	
	@Autowired
	private  ProfileService profileService;
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public Profile getProfile() {
		return profileService.getProfile(getProfileId());
	}
	
}
