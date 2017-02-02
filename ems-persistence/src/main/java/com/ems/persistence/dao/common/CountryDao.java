package com.ems.persistence.dao.common;

import org.springframework.data.repository.CrudRepository;
import com.ems.persistence.domain.common.Country;

public interface CountryDao extends CrudRepository<Country, Long>{

}
