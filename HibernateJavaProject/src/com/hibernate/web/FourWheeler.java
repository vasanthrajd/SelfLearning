package com.hibernate.web;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Car")
public class FourWheeler extends Vehicle {
	private String StreeingWheel;

	public String getStreeingWheel() {
		return StreeingWheel;
	}

	public void setStreeingWheel(String streeingWheel) {
		StreeingWheel = streeingWheel;
	}
	
}
