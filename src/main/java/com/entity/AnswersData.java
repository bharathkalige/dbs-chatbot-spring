package com.entity;

import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "ANSWERS")
public class AnswersData {
	
	@Id
	@Column(name = "ANSWER_ID")
	private String answer_id;
	
	
	@Column(name = "USER_ID")
	private String user_id;
	
	@Column(name = "DESCRIPTION")
	private String Description;
	
	@Column(name = "LIKES")
	private int likes;
	
	@Column(name = "DISLIKES")
	private int dislikes;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="QUESTION_ID")
	private QuestionData question;
	
	public AnswersData() {
		// TODO Auto-generated constructor stub
	}
	
	


	public String getAnswer_id() {
		return answer_id;
	}




	public void setAnswer_id(String answer_id) {
		this.answer_id = answer_id;
	}




	public String getUser_id() {
		return user_id;
	}




	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}




	public AnswersData(String answer_id, String user_id, String description, int likes, int dislikes) {
		this.answer_id = answer_id;
		this.user_id = user_id;
		Description = description;
		this.likes = likes;
		this.dislikes = dislikes;
	}




	public QuestionData getQuestion() {
		return question;
	}


	public void setQuestion(QuestionData optional) {
		this.question = optional;
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
	
	
	

}
