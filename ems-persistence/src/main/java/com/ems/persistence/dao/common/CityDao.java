package com.ems.persistence.dao.common;

import org.springframework.data.repository.CrudRepository;
import com.ems.persistence.domain.common.City;

public interface CityDao extends CrudRepository<City, Long>{

}
