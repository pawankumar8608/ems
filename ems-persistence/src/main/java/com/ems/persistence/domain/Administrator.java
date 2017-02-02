package com.ems.persistence.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="administrator")
public class Administrator implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7714198010763777905L;
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="user_name", nullable=false)
	private String userName;
	
	@Column(name="password", nullable=false)
	private String password;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="admin")
	Collection<AdminRole> adminRoles= new ArrayList<AdminRole>();
	
	@Column(name="first_name", nullable=false)
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email", nullable=false)
	private String email;
	
	@Column(name="mobile_no")
	private String mobileNumber;
	
	@Column(name="address1", nullable=false)
	private String address1;
	
	@Column(name="address2")
	private String address2;
	
	@Column(name="country_id", nullable=false)
	private int countryId;
	
	@Column(name="state_id", nullable=false)
	private int stateId;
	
	@Column(name="city_id", nullable=false)
	private int cityId;
	
	@Column(name="enabled", columnDefinition="BIT")
	private boolean enabled;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public Collection<AdminRole> getAdminRoles() {
		return adminRoles;
	}

	public void setAdminRoles(Collection<AdminRole> adminRoles) {
		this.adminRoles = adminRoles;
	}

}
