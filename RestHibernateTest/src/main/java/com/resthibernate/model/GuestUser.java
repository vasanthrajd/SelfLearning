package com.resthibernate.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;


public class GuestUser extends ImmigrantUser{

	@OneToMany(cascade=CascadeType.ALL)
	private Country visitingCountry;

	public Country getVisitingCountry() {
		return visitingCountry;
	}

	public void setVisitingCountry(Country visitingCountry) {
		this.visitingCountry = visitingCountry;
	}
	
	
}
