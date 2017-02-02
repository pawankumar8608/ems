package com.ems.admin.controller;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ems.admin.service.CountryStateCityService;
import com.ems.persistence.domain.common.City;
import com.ems.persistence.domain.common.State;

@Controller
public class CountryStateCityController {
	
	@Autowired
	private CountryStateCityService cscService;
	
	@RequestMapping(value = "getStateByCountryId", method = RequestMethod.GET)
	@ResponseBody
	public Set<State> getStateByCountryId(@RequestParam("countryId") int countryId){
		  
		   return cscService.getStateByCountryId(countryId);
	}
	
	@RequestMapping(value = "getCityByStateId", method = RequestMethod.GET)
	@ResponseBody
	public Set<City> getCityByStateId(@RequestParam("stateId") int stateId){
		  
		   return cscService.getCityByStateId(stateId);
	}

}
