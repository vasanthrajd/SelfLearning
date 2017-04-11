package com.hibernate.web;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Bike")
public class TwoWheeler extends Vehicle {

		private String StreeingHandle;

		public String getStreeingHandle() {
			return StreeingHandle;
		}

		public void setStreeingHandle(String streeingHandle) {
			StreeingHandle = streeingHandle;
		}
		
		
}

