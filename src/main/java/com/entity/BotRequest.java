package com.entity;

public class BotRequest {
	
	private String uid;
	private String requestData;
	
	public BotRequest() {
		// TODO Auto-generated constructor stub
	}

	

	public BotRequest(String uid, String requestData) {
		this.uid = uid;
		this.requestData = requestData;
	}


	public String getUid() {
		return uid;
	}



	public void setUid(String uid) {
		this.uid = uid;
	}



	public String getRequestData() {
		return requestData;
	}

	public void setRequestData(String requestData) {
		this.requestData = requestData;
	}
	
	
	
}
