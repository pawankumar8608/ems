package com.ems.admin.service;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ems.admin.dto.UserForm;
import com.ems.persistence.dao.UserDao;
import com.ems.persistence.domain.User;

public class UserServiceImpl implements UserService{

	@Resource
	private UserDao userDao;
	
	@Autowired
	@Qualifier("passwordEncoder")
	private BCryptPasswordEncoder encoder;
	
	@Override
	public List<User> findAllUsers() {
		return (List<User>) userDao.findAll();
	}

	@Override
	public void createUser(UserForm userForm) {
		User user = new User();
		user.setUserName(userForm.getUserName());
		user.setFirstName(userForm.getFirstName());
		user.setPassword(userForm.getPassword());
		user.setLastName(userForm.getLastName());
		user.setEmail(userForm.getEmail());
		user.setMobileNo(userForm.getMobileNo());
		user.setAddress(userForm.getAddress());
		user.setCountryId(userForm.getCountryId());
		user.setStateId(userForm.getStateId());
		user.setCityId(userForm.getCityId());
		user.setEnabled(userForm.isEnabled());
        userDao.save(user);		
	}

	@Override
	public User findByExactUserName(String userName) {
		   User user = userDao.findByUserName(userName);
		   return user;
	}

	@Override
	public User authenticate(String userName, String password) {
		   if(null != userName && null != password){
			   User user = userDao.findByUserName(userName);
			   if(null != user){
				   String encodedPassword = user.getPassword();
				   if(encoder.matches(password, encodedPassword)){
					   return user;
				   }
			   }
		   }
		        return null;
	}

}
