package com.ems.persistence.domain.common;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="city")
public class City implements Serializable{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1967489559269308813L;

	@Id
	@GeneratedValue
	private long id;
	
	@NotNull
	@Column(name="name")
	private String name;
	
	private boolean enabled;
	
	@ManyToOne
	private Country country;
	
	@ManyToOne
	private State state;
	
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
