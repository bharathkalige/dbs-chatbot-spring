package com.entity;


public class AnswerRequest {

	
	private String user_id;
	
	private String Description;
	
	private int likes;
	
	private int dislikes;
	
	private String question_id;
	
	
	public AnswerRequest() {
		// TODO Auto-generated constructor stub
	}


	public AnswerRequest(String user_id, String description, int likes, int dislikes, String question_id) {
		this.user_id = user_id;
		Description = description;
		this.likes = likes;
		this.dislikes = dislikes;
		this.question_id = question_id;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getDescription() {
		return Description;
	}


	public void setDescription(String description) {
		Description = description;
	}


	public int getLikes() {
		return likes;
	}


	public void setLikes(int likes) {
		this.likes = likes;
	}


	public int getDislikes() {
		return dislikes;
	}


	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}


	public String getQuestion_id() {
		return question_id;
	}


	public void setQuestion_id(String question_id) {
		this.question_id = question_id;
	}
	
	
	

}
