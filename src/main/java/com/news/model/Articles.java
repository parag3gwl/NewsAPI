package com.news.model;

import java.io.Serializable;
import java.util.List;

public class Articles implements Serializable{
	private static final long serialVersionUID = -4458926482850050935L;
	public String title;
	public String description;
	public String url;

	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Articles(String title, String description, String url) {
		super();
		this.title = title;
		this.description = description;
		this.url = url;
	}
	
	
}
