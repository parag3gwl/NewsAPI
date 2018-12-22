package com.news.model;

import java.io.Serializable;

public class Articles implements Serializable{
	private static final long serialVersionUID = -4458926482850050935L;
	
	private String title;
	private String description;
	private String url;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
