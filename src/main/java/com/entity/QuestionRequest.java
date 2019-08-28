package com.entity;


public class QuestionRequest {

	private String user_id;
	
	private String title;
	
	private String description;
	
	public QuestionRequest() {
		// TODO Auto-generated constructor stub
	}

	
	public QuestionRequest(String user_id, String title, String description) {
		this.user_id = user_id;
		this.title = title;
		this.description = description;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


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
	
	
}
