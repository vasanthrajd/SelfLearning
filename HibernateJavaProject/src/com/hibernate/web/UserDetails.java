package com.hibernate.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverrides;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Type;

//@Entity ( name="user_details")
//@NamedQuery(name="user_details.byId", query = "from user_details where userId = ?")
//@org.hibernate.annotations.Entity(selectBeforeUpdate=true)
@Entity
@NamedQuery(name="user_details.byId", query = "from UserDetails where userId = ?")
/* It is a Native SQL Query.
 * @NamedNativeQuery(name = "user_details.byName", query = " select * from USER_details where userName=?", resultClass=UserDetails.class)
 */

@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Table(name="USER_details")
public class UserDetails {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	
	private String userName;
	
	/*@OneToMany(cascade=CascadeType.PERSIST)
	
	private Collection<Vehicle> vehicle=new ArrayList<Vehicle>();
	*/
	/*@ManyToMany
	private Collection<Vehicle> vehicle=new ArrayList<Vehicle>();
	*/
	/*
	 * One to One Annotation 
	 */
	/*
	@OneToOne
	@JoinColumn(name="VEHICLE_ID")
	private Vehicle vehicle;*/
	
	/*
		@OneToMany(mappedBy="user")
	
	 *  Associations marked as mappedBy must not define database mappings like @JoinTable or @JoinColumn: 

	
	@JoinTable(name="User_Vehicle",
			   joinColumns=@JoinColumn(name="User_Details_ID"),
			   inverseJoinColumns=@JoinColumn(name="Vehicle_ID"))
	*/
	

	/* Another Class acts as an Primary Key for all the fields present under that. 
	 * @EmbeddedId
	private User user;*/
	


	/*@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="user_Address",
			  joinColumns=@JoinColumn(name="USER_PRIMARY_id"))
	
	@GenericGenerator(name = "sequence-genID", strategy = "sequence")
	@CollectionId(columns = { @Column(name="Address_ID") }, generator = "sequence-genID", type = @Type(type="long"))
	
	private Collection<Address> address=new ArrayList<Address>();
	
	public void setAddress(Collection<Address> address) {
		this.address = address;
	}

	public Collection<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}

*/	/*@Embedded
	@AttributeOverrides({
		@AttributeOverride (name="street",column=@Column(name="home_street")),
		@AttributeOverride (name="city",column=@Column(name="home_city")),
		@AttributeOverride (name="state",column=@Column(name="home_state")),
		@AttributeOverride (name="pincode",column=@Column(name="home_pincode"))})
	private Address homeAddress;
*/
	public int getUserId() {
		return userId;
	}

	/*public Collection<Vehicle> getVehicle() {
		return vehicle;
	}

	public void setVehicle(Collection<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}*/

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	

	public String getUserName() {
		return userName;
	}

/*	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
*/
	public void setUserName(String userName) {
		this.userName = userName;
	}

/*	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}*/

/*	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
		
*/	
}
