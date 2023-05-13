
package com.quizes.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "quiz")
public class Quiz {

	
	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "question")
	private String question;

	private String correct_answer;

	private String wrong_op1;
	private String wrong_op2;
	private String wrong_op3;
	private String category;
	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Quiz [id=" + id + ", question=" + question + ", correct_answer=" + correct_answer + ", wrong_op1="
				+ wrong_op1 + ", wrong_op2=" + wrong_op2 + ", wrong_op3=" + wrong_op3 + ", category=" + category + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getCorrect_answer() {
		return correct_answer;
	}

	public void setCorrect_answer(String correct_answer) {
		this.correct_answer = correct_answer;
	}

	public String getWrong_op1() {
		return wrong_op1;
	}

	public void setWrong_op1(String wrong_op1) {
		this.wrong_op1 = wrong_op1;
	}

	public String getWrong_op2() {
		return wrong_op2;
	}

	public void setWrong_op2(String wrong_op2) {
		this.wrong_op2 = wrong_op2;
	}

	public String getWrong_op3() {
		return wrong_op3;
	}

	public void setWrong_op3(String wrong_op3) {
		this.wrong_op3 = wrong_op3;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Quiz(Integer id, String question, String correct_answer, String wrong_op1, String wrong_op2,
			String wrong_op3, String category) {
		super();
		this.id = id;
		this.question = question;
		this.correct_answer = correct_answer;
		this.wrong_op1 = wrong_op1;
		this.wrong_op2 = wrong_op2;
		this.wrong_op3 = wrong_op3;
		this.category = category;
	}

}
