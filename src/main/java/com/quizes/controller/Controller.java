package com.quizes.controller;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quizes.model.Person;
import com.quizes.model.Quiz;
import com.quizes.repository.QuizRepo;
import com.quizes.srvice.QuizService;

@RestController
public class Controller {
	@Autowired
	QuizService quizservice;
	@Autowired
	QuizRepo qr;

	@RequestMapping("/hello")
	public String hello() {
		return "hello world";
	}

	/*
	 * @GetMapping(value="/callclient") public String getHelloClient() { String
	 * uri="https://restcountries.eu/rest/v2/all"; RestTemplate rst=new
	 * RestTemplate();
	 * 
	 * String result=rst.getForObject(uri, String.class); return result; }
	 */
	@GetMapping(value = "/countries")
	public ResponseEntity<?> getCountrys() {
		try {

			// String uri =
			// "https://opentdb.com/api.php?amount=10&category=9&difficulty=easy&type=multiple";
			String uri = "https://opentdb.com/api.php?amount=10&category=17&difficulty=medium&type=multiple";
			RestTemplate restTemplate = new RestTemplate();

			String result = restTemplate.getForObject(uri, String.class);
			System.out.println(result);
			System.out.println(result.charAt(1));
			Object file = JSONValue.parse(result);
			JSONObject jsonObjectdecode = (JSONObject) file;
			ArrayList<Quiz> arrquiz = new ArrayList<Quiz>();
			ArrayList<Map<String, Object>> arrayList = (JSONArray) jsonObjectdecode.get("results");

			/*
			 * for (Map<String, Object> ele : arrayList) { ArrayList<String> arl = new
			 * ArrayList<String>(); arl = (ArrayList<String>) ele.get("incorrect_answers");
			 * Quiz quiz = new Quiz(0, (String) ele.get("question"), (String)
			 * ele.get("correct_answer"), arl.get(0), arl.get(1), arl.get(2), (String)
			 * ele.get("category")); Quiz q2 = new Quiz(1, "Who is prime minister?",
			 * "Modiji", "RG", "ak", "sg", "Politics");
			 * 
			 * System.out.println(quiz); arrquiz.add(quiz); quizservice.save(quiz); }
			 */
			System.out.println("Shrey");

			List<Quiz> qu = qr.findbycategory("General Knowledge");
			for (Quiz q : qu) {
				System.out.println(q.getCorrect_answer());
			}

			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Error!, Please try again", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
