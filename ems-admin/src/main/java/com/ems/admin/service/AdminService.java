package com.ems.admin.service;

import com.ems.persistence.domain.Administrator;

public interface AdminService {
	
	public Administrator authenticate(String userName, String password);
	
	

}
