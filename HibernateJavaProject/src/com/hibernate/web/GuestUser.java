package com.hibernate.web;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("GuestUserInfo")
public class GuestUser extends UserInfo {
	@OneToOne
	private Country visitingCountry;

	public Country getVisitingCountry() {
		return visitingCountry;
	}

	public void setVisitingCountry(Country visitingCountry) {
		this.visitingCountry = visitingCountry;
	}
	
}
