package com.ems.persistence.dao;

import org.springframework.data.repository.CrudRepository;
import com.ems.persistence.domain.Administrator;

public interface AdministratorDao extends CrudRepository<Administrator, Long>{
	
	Administrator findByUserName(String userName);

}
