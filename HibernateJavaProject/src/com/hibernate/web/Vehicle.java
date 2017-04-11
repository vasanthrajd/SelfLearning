package com.hibernate.web;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)

/* Table Per Class, where every Class has it's own Table
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)

*/
/*
 * It will have only one table and most of the column will have null values.,
 * which is not a proper Normalization form.
 * @Inheritance(strategy=InheritanceType.SINGLE_TABLE) 
 * It is good for the Single Table Stratergy and can't be used for the Multiple Tables.
@DiscriminatorColumn(name="Vehicle_Type",discriminatorType=DiscriminatorType.STRING)
*/public class Vehicle {
	@Id @GeneratedValue
	private int vehicleId;
	private String vehicleName;
	
	
/*	@ManyToMany(mappedBy="vehicle")
	@NotFound(action=NotFoundAction.IGNORE)
	private Collection<UserDetails> userList=new ArrayList<UserDetails>();
*/	
	/*
	@ManyToOne
	@JoinColumn(name="MappedUSERID")
	private UserDetails user;
	*/
	
	
	
	/*public UserDetails getUser() {
		return user;
	}
	public void setUser(UserDetails user) {
		this.user = user;
	}
	*/public int getVehicleId() {
		return vehicleId;
	}
/*	public Collection<UserDetails> getUserList() {
		return userList;
	}
	public void setUserList(Collection<UserDetails> userList) {
		this.userList = userList;
	}
*/	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	
}
