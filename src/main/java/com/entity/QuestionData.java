package com.entity;

import java.util.HashSet;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "QUESTIONS")
public class QuestionData {
	
	@Id
	@Column(name = "QUESTION_ID")
	private String question_id;
	
	@Column(name = "USER_ID")
	private String user_id;
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@OneToMany
	@JoinColumn(name="QUESTION_ID")
	Set<AnswersData> answers = new HashSet<>();
	
	public Set<AnswersData> getAnswers() {
		return answers;
	}




	public void setAnswers(Set<AnswersData> answers) {
		this.answers = answers;
	}




	public QuestionData() {
		// TODO Auto-generated constructor stub
	}

	


	public QuestionData(String question_id, String user_id, String title, String description) {
		this.question_id = question_id;
		this.user_id = user_id;
		this.title = title;
		this.description = description;
	}




	public String getQuestion_id() {
		return question_id;
	}




	public void setQuestion_id(String question_id) {
		this.question_id = question_id;
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
