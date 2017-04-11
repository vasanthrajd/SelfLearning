package com.resthibernate.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public enum Status {
	SUCCESS("SUCESS"), FAILURE("FAILURE"), UNAUTHORIZED("UNAUTHORIZED");
	
	private String status;
	private Status(String status){
		this.status=status;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
