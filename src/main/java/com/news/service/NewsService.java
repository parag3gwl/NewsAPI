package com.news.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.news.model.Articles;
import com.news.model.NewsContents;
import com.news.model.NewsResponse;
import com.news.utils.Constants;


//Service class
@Service
public class NewsService {
	
	@Autowired
    private RestTemplate restTemplate;
	
	
	public List<NewsResponse> getNews(String country, String category, String keyword) {
		
		//RestTemplate restTemplate = new RestTemplate();
		String uri = Constants.uri + "?country=" + country + "&category=" + category + "&apiKey=" + Constants.apikey;
		ResponseEntity<NewsContents> restResponse = restTemplate.getForEntity(uri, NewsContents.class);
		if(restResponse == null) {
			return new ArrayList<NewsResponse>();
		}
		System.out.println(restResponse.getBody());
		List<NewsResponse> responseList = new ArrayList<>();
	
		for(Articles a : restResponse.getBody().getArticles()){
			NewsResponse response = new NewsResponse();
			response.setCategory(category);
			response.setCountry(country);
			response.setDescription(a.getDescription());
			response.setNewsTitle(a.getTitle());
			response.setFilter_keyword(keyword);
			responseList.add(response);

		}
		return responseList;
				
	}
}