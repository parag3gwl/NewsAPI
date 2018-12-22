package com.news.model;

import javax.validation.constraints.Max;

public class NewsResponse {
	private String Country;
	
	private String Category;
	
	private String Filter_keyword;
	
	private String NewsTitle;
	
	@Max(100)
	private String Description;
	
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public String getFilter_keyword() {
		return Filter_keyword;
	}
	public void setFilter_keyword(String filter_keyword) {
		Filter_keyword = filter_keyword;
	}
	public String getNewsTitle() {
		return NewsTitle;
	}
	public void setNewsTitle(String newsTitle) {
		NewsTitle = newsTitle;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
}
