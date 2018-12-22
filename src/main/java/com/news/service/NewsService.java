package com.news.service;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.news.model.NewsContents;
import com.news.model.NewsResponse;
import com.news.utils.Constants;


//Service class
@Service
public class NewsService {
	
	public NewsResponse getNews(String country, String category) {
		
		RestTemplate restTemplate = new RestTemplate();
		String uri = Constants.uri + "?country=" + country + "&category=" + category + "&apiKey=" + Constants.apikey;
		ResponseEntity<NewsContents> response = restTemplate.getForEntity(uri, NewsContents.class);
		System.out.println(response.getBody());
		NewsResponse resp = new NewsResponse();
		resp.setCategory(category);
		resp.setCountry(country);
		resp.setDescription(response.getBody().getArticles().get(0).getDescription());
		resp.setNewsTitle(response.getBody().getArticles().get(0).getTitle());
		
//		for(Articles a : response.getBody().getArticles()){
//			System.out.println(a);
//		}
		return resp;
				
	}
}