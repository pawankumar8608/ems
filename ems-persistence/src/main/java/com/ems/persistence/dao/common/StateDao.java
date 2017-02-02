package com.ems.persistence.dao.common;

import org.springframework.data.repository.CrudRepository;
import com.ems.persistence.domain.common.State;

public interface StateDao extends CrudRepository<State, Long>{

}
