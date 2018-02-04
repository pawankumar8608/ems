package com.ems.persistence.domain;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import com.ems.persistence.domain.common.City;
import com.ems.persistence.domain.common.Country;
import com.ems.persistence.domain.common.State;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Entity
@Data
@Table(name="user")
public class User implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5276314425439956977L;

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@NotNull
	@Column(name="user_name", unique = true)
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@NotNull
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@NotNull
	@Column(name="email")
	private String email;
	
	@Column(name="mobile_no")
	private String mobileNo;
	
	@NotNull
	@Column(name="address")
	private String address;
	
	@OneToOne
	@JoinColumn(name="country_id", nullable = false, insertable = false, updatable = false)
	@JsonIgnore
	private Country country;
	
	@OneToOne
	@JoinColumn(name="state_id", nullable = false, insertable = false, updatable = false)
	@JsonIgnore
	private State state;
	
	@OneToOne
	@JoinColumn(name="city_id", nullable = false, insertable = false, updatable = false)
	@JsonIgnore
	private City city;
	
	@NotNull
	@Column(name="country_id")
	private int countryId;
	
	@NotNull
	@Column(name="state_id")
	private int stateId;
	
	@NotNull
	@Column(name="city_id")
	private int cityId;
	
	@Column(name="enabled")
	private boolean enabled = true;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar date_created;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar last_date_modified;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar last_date_access;
	
	/*public long getId() {
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

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
		
	public Calendar getDate_created() {
		return date_created;
	}

	public void setDate_created(Calendar date_created) {
		this.date_created = date_created;
	}

	public Calendar getLast_date_modified() {
		return last_date_modified;
	}

	public void setLast_date_modified(Calendar last_date_modified) {
		this.last_date_modified = last_date_modified;
	}

	public Calendar getLast_date_access() {
		return last_date_access;
	}

	public void setLast_date_access(Calendar last_date_access) {
		this.last_date_access = last_date_access;
	}
	
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}*/
	
}
