package com.quizvocabulary.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AbstractController {
	
	protected String getProfileId() {
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	     return auth.getName();
	}
}
