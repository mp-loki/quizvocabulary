package com.quizvocabulary.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.quizvocabulary.data.model.Profile;
import com.quizvocabulary.service.ProfileServiceImpl;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/")
public class ProfileController extends AbstractController {
	
	@Autowired
	private  ProfileServiceImpl profileService;
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ResponseEntity<Profile> getProfile() {
		Profile profile = profileService.getProfile(getProfileId());
		if (profile != null) {
			return new ResponseEntity<Profile>(profile, HttpStatus.OK);
		} else {
			return new ResponseEntity<Profile>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public ResponseEntity<?> saveOrUpdateProfile(@RequestBody Profile profile) {
		log.info("Saving profile: " + profile);
		profile.setId(getProfileId());
		try {
		Profile savedProfile = profileService.saveOrUpdateProfile(profile);
		return new ResponseEntity<Profile>(savedProfile, HttpStatus.OK);
		} catch (Exception e) {
			log.error(String.format("Unable to save profile: %s. Reason: %s", profile, e.getMessage()), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
}
