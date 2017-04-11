package com.resthibernate.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResponseModel{

	private Status status;
	private String failureReason;
	public ResponseModel(){
		this(Status.FAILURE,"");
	}
	
	public ResponseModel(Status status, String failureReason) {
		// TODO Auto-generated constructor stub
		this.status=status;
		this.failureReason=failureReason;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getFailureReason() {
		return failureReason;
	}
	public void setFailureReason(String failureReason) {
		this.failureReason = failureReason;
	}
	
}
