package com.resthibernate.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Type;

import com.resthibernate.model.Carrier;
import com.resthibernate.model.Currency;
import com.resthibernate.model.TimeZone;

@Entity
@XmlRootElement
public class Country{
	@Id 
	private String id;
	private String code;	
	private boolean supportPaypal;
	
	/*
	 * Relationship with other Tables. 
	 * OneToOne   -  UniDirectional : Currency
	 * OneToMany  -  BiDirectional  : TimeZone
	 * ManyToMany -  BiDirectional  : Carrier 
	 */
	@XmlElement
	@OneToOne(cascade=CascadeType.ALL,optional=true)	
	private Currency currency;
	
	/* By doing so, we can prevent a new table to be created for having the relationship.
	 * @OneToMany(mappedBy="property")
	 */
	@XmlElement
	@OneToMany(cascade=CascadeType.ALL,mappedBy="country")
	private Collection<TimeZone> timeZone = new HashSet<TimeZone>();
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="carrier_Id_VALUE")
	@XmlElement
	private Set<Carrier> carrier=new HashSet<Carrier>();
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isSupportPaypal() {
		return supportPaypal;
	}

	public void setSupportPaypal(boolean supportPaypal) {
		this.supportPaypal = supportPaypal;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Collection<TimeZone> getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(Collection<TimeZone> timeZone) {
		this.timeZone = timeZone;
	}

	public Set<Carrier> getCarrier() {
		return carrier;
	}

	public void setCarrier(Set<Carrier> carrier) {
		this.carrier = carrier;
	}

	
	

	
}
