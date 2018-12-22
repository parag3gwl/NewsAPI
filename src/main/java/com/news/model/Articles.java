package com.news.model;

import java.io.Serializable;
import java.util.List;

public class Articles implements Serializable{
	private static final long serialVersionUID = -4458926482850050935L;
	
	//private ArticlesData dataList;
	public String title;
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

	public String description;
	public String url;

}
