package com.vasanth.restapi.scmessenger.Service;

import org.glassfish.jersey.server.JSONP;

import com.vasanth.restapi.scmessenger.model.ResponseModel;

public class MessageServiceResponse extends ResponseModel{
	
	private String Message="Custom Message Check";
	
	private String failureResponse;

	public String getFailureResponse() {
		return failureResponse;
	}
	
	
	@JSONP
	@Override
	public String getResponse() {
		// TODO Auto-generated method stub
		return super.getResponse();
	}


	@JSONP
	@Override
	public void setResponse(String response) {
		// TODO Auto-generated method stub
		super.setResponse(response);
	}



	public void setFailureResponse(String failureResponse) {
		this.failureResponse = failureResponse;
	}

	public String getMessage() {
		return Message;
	}

	public MessageServiceResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MessageServiceResponse(String status, String response) {
		super(status, response);
		// TODO Auto-generated constructor stub
	}

	public void setMessage(String message) {
		Message = message;
	}
	
	
}
