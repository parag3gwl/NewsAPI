package com.news.model;

import java.io.Serializable;
import java.util.List;

public class NewsContents implements Serializable{
	private static final long serialVersionUID = -1141633656346757079L;
	
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	} 
	
	private List<Articles> articles;

	public List<Articles> getArticles() {
		return articles;
	}

	public void setArticles(List<Articles> articles) {
		this.articles = articles;
	}
	
}
