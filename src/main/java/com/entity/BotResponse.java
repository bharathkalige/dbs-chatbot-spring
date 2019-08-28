package com.entity;

public class BotResponse {
	
	private int status;
	private String responseData;
	
	public BotResponse() {
		// TODO Auto-generated constructor stub
	}

	
	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public BotResponse(int status, String responseData) {
		super();
		this.status = status;
		this.responseData = responseData;
	}


	public String getResponseData() {
		return responseData;
	}

	public void setResponseData(String responseData) {
		this.responseData = responseData;
	}
	
	

}
