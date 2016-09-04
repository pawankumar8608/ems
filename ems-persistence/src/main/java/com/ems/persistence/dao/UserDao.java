package com.ems.persistence.dao;

import org.springframework.data.repository.CrudRepository;
import com.ems.persistence.domain.User;

public interface UserDao extends CrudRepository<User, Long>{
	
       public User findByUserName(String userName);
}
