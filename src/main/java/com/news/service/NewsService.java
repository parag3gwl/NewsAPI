package com.news.service;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.news.model.Articles;
import com.news.model.NewsResponse;
import com.news.utils.Constants;


//Service class
@Service
public class NewsService {
	
	public NewsResponse getNews(String country, String category) {
		
		RestTemplate restTemplate = new RestTemplate();
		String uri = Constants.uri + "?country=" + country + "&category=" + category + "&apiKey=" + Constants.apikey;
		ResponseEntity<Articles> response = restTemplate.getForEntity(uri, Articles.class);
		System.out.println(response.getBody());
		return new NewsResponse();
				
	}
}