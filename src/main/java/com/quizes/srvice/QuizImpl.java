package com.quizes.srvice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.quizes.repository.*;
import com.quizes.model.Quiz;
@Service
public class QuizImpl implements QuizService {
	@Autowired
	QuizRepo quizrepo;

	@Override
	public List<Quiz> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Quiz quiz) {
		// TODO Auto-generated method stub
		quizrepo.save(quiz);
		
	}

	@Override
	public Quiz findbyId(Integer id) {
		// TODO Auto-generated method stub
		Quiz quiz=quizrepo.findById(id);
		return quiz;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public List<Quiz> findbycategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

}
