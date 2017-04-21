package com.hibernate.web;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Type;

@Entity
public class Country {
	@Id 
	private String id;
	private String code;	
	private boolean supportPaypal;
	
	@OneToOne(cascade=CascadeType.ALL,optional=false)	
	private Currency currency;
	
	/* By doing so, we can prevent a new table to be created for having the relationship.
	 * @OneToMany(mappedBy="property")
	 */
	@OneToMany(cascade=CascadeType.ALL,mappedBy="country")
	private Set<TimeZone> timeZone = new HashSet<TimeZone>();
	
	@ManyToMany
	@JoinColumn(name="carrier_Id_VALUE")
	private Set<Carrier> carrier=new HashSet<Carrier>();
	
	public Collection<Carrier> getCarrier() {
		return carrier;
	}
	public void setCarrier(Set<Carrier> carrier) {
		this.carrier = carrier;
	}
	public Set<TimeZone> getTimeZone() {
		return timeZone;
	}
	public void setTimeZone(Set<TimeZone> timeZone) {
		this.timeZone = timeZone;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	/*private TimeZone timeZone;
	
	
	public TimeZone getTimeZone() {
		return timeZone;
	}
	public void setTimeZone(TimeZone timeZone) {
		this.timeZone = timeZone;
	}*/
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
	@Override
	public String toString() {
		return "Country [id=" + id + ", code=" + code + ", supportPaypal=" + supportPaypal + "]";
	}
	
}
