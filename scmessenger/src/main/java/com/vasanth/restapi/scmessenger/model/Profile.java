package com.vasanth.restapi.scmessenger.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class Profile extends ResponseModel{

	private long id;
	private String profileName;
	private String firstName;
	private String lastName;
	private Date createdDate;
	
	public Profile(){
		
	}
	
	public Profile(long id, String profileName, String firstName, String lastName) {
		super();
		this.id=id;
		this.profileName = profileName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.createdDate= new Date();
	}

	public long getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setId(long id) {
		this.id = id;
	}
	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	
	
}
