package com.ems.admin.service;

import java.util.Set;
import com.ems.persistence.domain.common.City;
import com.ems.persistence.domain.common.Country;
import com.ems.persistence.domain.common.State;

public interface CountryStateCityService {

	  public Set<Country> getAllCountries();
	  
	  public Set<State> getAllStates();
	  
	  public Set<City> getAllCities();
	  
	  public Set<State> getStateByCountryId(int countryId);
	  
	  public Set<City> getCityByStateId(int stateId);

	  
}
