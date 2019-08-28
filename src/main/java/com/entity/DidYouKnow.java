package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Didyouknow")
public class DidYouKnow {
	
	@Id
	@Column(name="line")
	public String line;

	
	public DidYouKnow() {
		// TODO Auto-generated constructor stub
	}


	public DidYouKnow(String line) {
		this.line = line;
	}


	public String getLine() {
		return line;
	}


	public void setLine(String line) {
		this.line = line;
	}
	
	
	
}
