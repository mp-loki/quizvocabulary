package com.quizvocabulary;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.NoArgGenerator;

@Configuration
public class QuizvocabularyConfig {
	
	@Bean
	public NoArgGenerator getNoArgGenerator() {
		return Generators.timeBasedGenerator(); 
	} 
}
