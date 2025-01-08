package com.dagim.webcrawler.model;

public class MessageResponse {
	
	private String responseMessage;
	
	
	public MessageResponse() {
		super();
	}

	public MessageResponse(String responseMessage) {
		super();
		this.responseMessage = responseMessage;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	
}
