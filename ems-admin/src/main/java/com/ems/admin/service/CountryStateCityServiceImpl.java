package com.ems.admin.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.ems.persistence.dao.common.CityDao;
import com.ems.persistence.dao.common.CountryDao;
import com.ems.persistence.dao.common.StateDao;
import com.ems.persistence.domain.common.City;
import com.ems.persistence.domain.common.Country;
import com.ems.persistence.domain.common.State;

public class CountryStateCityServiceImpl implements CountryStateCityService{
	
	@Autowired
	private CountryDao countryDao;
	
	@Autowired
	private StateDao stateDao;
	
	@Autowired
	private CityDao cityDao;

	@Override
	public Set<Country> getAllCountries() {
		   Set<Country> countryList = new HashSet<Country>((List<Country>)countryDao.findAll());
		   return countryList;
	}
	
	@Override
	public Set<State> getAllStates() {
		   Set<State> stateList = new HashSet<State>((List<State>)stateDao.findAll());
		   return stateList;
	}

	@Override
	public Set<City> getAllCities() {
     	   Set<City> cityList = new HashSet<City>((List<City>)cityDao.findAll());
		   return cityList;
	}

	@Override
	@Transactional
	public Set<State> getStateByCountryId(int countryId) {
		   Country country = countryDao.findOne((long) countryId);
   		   return new HashSet<State>(country.getStates());
   		   
	}

	@Override
	@Transactional
	public Set<City> getCityByStateId(int stateId) {
		   State state = stateDao.findOne((long) stateId);
		   return new HashSet<City>(state.getCities());
	}

	
}
