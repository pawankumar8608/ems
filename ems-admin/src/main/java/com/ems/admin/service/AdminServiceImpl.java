package com.ems.admin.service;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.ems.persistence.dao.AdministratorDao;
import com.ems.persistence.domain.Administrator;

public class AdminServiceImpl implements AdminService{

	@Resource
	private AdministratorDao adminDao;
	
	@Autowired
	@Qualifier("passwordEncoder")
	private BCryptPasswordEncoder encoder;
	
	@Override
	public Administrator authenticate(String userName, String password) {
		   if(null != userName && null != password){
			   Administrator admin = adminDao.findByUserName(userName);
			   if(null != admin){
				   String encodedPassword = admin.getPassword();
				   if(encoder.matches(password, encodedPassword)){
				      admin.getAdminRoles();
				      return admin;
				   }
			   }
			   
		   }
		      return null;
	}

}
