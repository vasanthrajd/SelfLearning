package com.resthibernate.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class CountryResponse extends ResponseModel{

	private Country country;

	public CountryResponse(){
		super();
	}
	
	public CountryResponse(Status status, String failureReason) {
		super(status, failureReason);
		// 
	}
	
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	

}
