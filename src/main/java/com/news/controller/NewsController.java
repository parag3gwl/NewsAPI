package com.news.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.news.model.NewsResponse;
import com.news.service.NewsService;

@RestController
public class NewsController {
	@Autowired
	NewsService newsService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@RequestMapping(value = "/getNews", method = RequestMethod.GET)
	public ResponseEntity<List<NewsResponse>> getNews(@RequestParam("country") String country,
			@RequestParam("category") String category, @RequestParam("keyword") String keyword) {
		if (validateInput(country, category)) {
			List<NewsResponse> response = newsService.getNews(country, category, keyword);
			return new ResponseEntity<List<NewsResponse>>(response, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

	}

	private boolean validateInput(String country, String category) {
		boolean isValid = true;

		if (country == null || country.isEmpty() || category == null || category.isEmpty()) {
			isValid = false;
		}

		return isValid;
	}
}
