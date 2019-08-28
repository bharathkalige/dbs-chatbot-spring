package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LIKEANDDISLIKE")
public class LikeAndDislike {
	
	@Id
	@Column(name="LIKE_ID")
	private String like_id;
	
	@Column(name="ANSWER_ID")
	private String answer_id;
	
	@Column(name="USER_ID")
	private String user_id;
	
	@Column(name="TYPE")
	private int type;
	
	
	public LikeAndDislike() {
		// TODO Auto-generated constructor stub
	}


	
	public LikeAndDislike(String like_id, String answer_id, String user_id, int type) {
		this.like_id = like_id;
		this.answer_id = answer_id;
		this.user_id = user_id;
		this.type = type;
	}


	

	public String getAnswer_id() {
		return answer_id;
	}



	public void setAnswer_id(String answer_id) {
		this.answer_id = answer_id;
	}



	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}


	public String getLike_id() {
		return like_id;
	}


	public void setLike_id(String like_id) {
		this.like_id = like_id;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	

}
