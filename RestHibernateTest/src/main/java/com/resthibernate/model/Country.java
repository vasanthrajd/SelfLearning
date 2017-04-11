package com.resthibernate.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Type;

@Entity
@XmlRootElement
public class Country{
	@Id 
	private String id;
	private String code;
	
	private boolean supportPaypal;
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
