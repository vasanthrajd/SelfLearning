package com.resthibernate.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResponseResult<T> extends ResponseModel{

	private T object;	
	
	public ResponseResult(T object) {
		super();
		this.object = object;
	}

	public ResponseResult(Status status, String failureReason){
		super(status,failureReason);
	}

	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}
	
		
	
}
