package com.quizes.srvice;

import java.util.List;


import com.quizes.model.Quiz;

public interface QuizService {

	List<Quiz> findAll();
	void save(Quiz expense);
	Quiz findbyId(Integer id);
	void delete(Long id);
	List<Quiz> findbycategory(String category);
	
}
