package com.ems.persistence.dao;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.ems.persistence.domain.User;

public interface UserDao extends CrudRepository<User, Long>{
	
       public User findByUserName(String userName);
       
       @Query("SELECT u.id, u.userName, u.firstName, u.email, u.address FROM User u")
       public List<Object[]> getUsers();
}
