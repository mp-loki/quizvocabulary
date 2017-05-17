package com.quizvocabulary.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Profile> getProfile(HttpServletResponse response) {
		Profile profile = profileService.getProfile(getProfileId());
		if (profile != null) {
			return new ResponseEntity<Profile>(profile, HttpStatus.OK);
		} else {
			return new ResponseEntity<Profile>(HttpStatus.NOT_FOUND);
		}
	}
	
}
