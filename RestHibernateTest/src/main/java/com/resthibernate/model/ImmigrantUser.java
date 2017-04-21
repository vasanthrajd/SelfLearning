package com.resthibernate.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;


public class ImmigrantUser extends UserDetails {

		@OneToOne(cascade=CascadeType.ALL)
		private Country immigrantCountry;

		public Country getImmigrantCountry() {
			return immigrantCountry;
		}

		public void setImmigrantCountry(Country immigrantCountry) {
			this.immigrantCountry = immigrantCountry;
		}
		
		
}
