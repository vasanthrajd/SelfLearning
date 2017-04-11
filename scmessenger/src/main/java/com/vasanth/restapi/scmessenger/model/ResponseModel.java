package com.vasanth.restapi.scmessenger.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResponseModel {
	private String status;
	private String response;
	public ResponseModel(){
		this("Unknown","Response Error");
	}
	
	public ResponseModel(String status, String response) {
		super();
		this.status = status;
		this.response = response;
	}
	@XmlElement
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@XmlElement
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	
	
}
