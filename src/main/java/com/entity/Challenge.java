package com.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CHALLENGES")
public class Challenge {
	@Id
	@Column(name="Challenge_ID")
	private int cid;
	
	
	@Column(name="TITLE")
	private String title;
	
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@OneToMany
	@JoinColumn(name="Challenge_ID")
	Set<Enroll>enroll =new HashSet<Enroll>();
	
	
	
	public Challenge() {
	}



	public Challenge(int cid, String title, String description) {
		this.cid = cid;
		this.title = title;
		this.description = description;
	}




	public int getCid() {
		return cid;
	}



	public void setCid(int cid) {
		this.cid = cid;
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



	public Set<Enroll> getEnroll() {
		return enroll;
	}



	public void setEnroll(Set<Enroll> enroll) {
		this.enroll = enroll;
	}
	
	
}