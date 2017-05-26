package com.quizvocabulary.data.model.quiz;

import java.util.List;

import lombok.Data;

@Data
public class Quiz {
	
	List<QuizEntry> entries;
}
