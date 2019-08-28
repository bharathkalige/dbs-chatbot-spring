package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Announcement")
public class Announcement {
	
	@Id
	@Column(name="line")
	public String line;

	public Announcement(String line) {
		this.line = line;
	}

	public Announcement() {

	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}
	
	
	}
