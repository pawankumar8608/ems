package com.ems.admin.service;

import java.util.List;
import com.ems.admin.dto.UserForm;
import com.ems.persistence.domain.User;

public interface UserService {
	 
	public List<Object[]> findUsers();
	
	public void createUser(UserForm user);
	
	public User findByExactUserName(String userName);
	
	public User authenticate(String userName, String password);
	
	public User loadUser(long id);
	
	public void updateUser(UserForm user);

}
