package com.resthibernate.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class TimeZone  {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int tid;
	private String name;
	private String description;
	private String shortDescription;
	
	/*
	 * Bi Directional Access for the Country Where it Belongs
	 */
	@ManyToOne
	@JoinColumn(name="Country_Id")
	
	private Country country;
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "TimeZone [tid=" + tid + ", name=" + name + ", description=" + description + ", shortDescription="
				+ shortDescription + ", country=" + country + "]";
	}
	
	
}
