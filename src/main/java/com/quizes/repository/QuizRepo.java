package com.quizes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.quizes.model.Quiz;

@Repository
public interface QuizRepo extends CrudRepository<Quiz, Long> {
	public List<Quiz> findAll();
	@Query(nativeQuery=true,value="select * from quiz  WHERE category=:n order by RAND() LIMIT 10")
public List<Quiz> findbycategory(@Param("n")String category);
	@Query("select q from Quiz q ")
public List<Quiz> findbycategory();
	Quiz findById(Integer id);
}
