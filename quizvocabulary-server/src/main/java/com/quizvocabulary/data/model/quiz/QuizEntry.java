package com.quizvocabulary.data.model.quiz;

import java.util.List;

import com.quizvocabulary.data.model.Logos;

import lombok.Data;

@Data
public class QuizEntry {
	
	Logos question;
	Logos answer;
	List<Logos> options;

}
