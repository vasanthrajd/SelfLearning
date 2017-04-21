package com.resthibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Type;

@Entity
@XmlRootElement
public class Currency {
	/*	
	 * Making the @Id acts as a ForeignKey of Country.
	 * @GenericGenerator(name = "foreignString", strategy = "foreign",
	    parameters=@Parameter(name = "property", value = "country"))

		@GeneratedValue(generator="foreignString") 
	*/

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String symbol;
	private String shortName;
	@Type(type = "yes_no")
	private boolean isDefault;
	
	/*
	 * To make the Currency and Country Tightly Coupled One to One Mapping.
	 * By Marking Field of Country to Map with only one Country.
	@OneToOne 
	@PrimaryKeyJoinColumn
	private Country country;
	
	
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	*/
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public boolean isDefault() {
		return isDefault;
	}
	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}
	
	
	
	
	
}
