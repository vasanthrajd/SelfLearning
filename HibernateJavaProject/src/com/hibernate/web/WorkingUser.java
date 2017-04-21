package com.hibernate.web;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class WorkingUser extends GuestUser{

	@OneToOne
	private Country workingCountry=new Country();

	public Country getWorkingCountry() {
		return workingCountry;
	}

	public void setWorkingCountry(Country workingCountry) {
		this.workingCountry = workingCountry;
	}
	
	
}
