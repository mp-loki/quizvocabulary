package com.quizvocabulary.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/")
public class UserController {
	
	 /* Maps to all HTTP actions by default (GET,POST,..)*/
	  @RequestMapping("/users")
	  public @ResponseBody String getUsers() {
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      String name = auth.getName();
	     
		log.info("*** getUsers called by " + name + " * " + auth.getPrincipal() + " * " + auth.getDetails());
	    return "{\"users\":[{\"firstname\":\"Richard\", \"lastname\":\"Feynman\"}," +
	           "{\"firstname\":\"Marie\",\"lastname\":\"Curie\"}]}";
	  }
	  
	  @RequestMapping("/users1")
	  public @ResponseBody String getUsers1() {
		log.info("*** getUsers called");
	    return "{\"users\":[{\"firstname\":\"Richard\", \"lastname\":\"Feynman\"}," +
	           "{\"firstname\":\"Marie\",\"lastname\":\"Curie\"}]}";
	  }

}
