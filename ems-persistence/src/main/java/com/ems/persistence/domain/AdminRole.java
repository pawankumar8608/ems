package com.ems.persistence.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="admin_role")
public class AdminRole implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7345205647040942245L;
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="role", nullable=false)
	private String role;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="admin_id", nullable=false)
	private Administrator admin;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Administrator getAdmin() {
		return admin;
	}

	public void setAdmin(Administrator admin) {
		this.admin = admin;
	}
	

}
