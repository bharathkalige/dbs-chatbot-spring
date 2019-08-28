package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BOTCHATS")
public class BotMessage {
	
	@Id
	@Column(name = "MID")
	private String mid;
	
	@Column(name = "UID")
	private String uid;
	
	@Column(name = "SENTBY")
	private int sentBy;
	
	@Column(name = "CONTENT")
	private String content;
	
	public BotMessage() {
		// TODO Auto-generated constructor stub
	}

	public BotMessage(String mid, String uid, int sentBy, String content) {
		this.mid = mid;
		this.uid = uid;
		this.sentBy = sentBy;
		this.content = content;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public int getSentBy() {
		return sentBy;
	}

	public void setSentBy(int sentBy) {
		this.sentBy = sentBy;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	

}
