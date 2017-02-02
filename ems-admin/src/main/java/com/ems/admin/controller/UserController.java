package com.ems.admin.controller;

import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.ems.admin.dto.UserForm;
import com.ems.admin.service.CountryStateCityService;
import com.ems.admin.service.UserService;
import com.ems.persistence.domain.User;
import com.ems.persistence.domain.common.City;
import com.ems.persistence.domain.common.Country;
import com.ems.persistence.domain.common.State;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private CountryStateCityService cscService;

	@RequestMapping(value = "searchUser", method = RequestMethod.GET)
	public ModelAndView searchUser() {

		ModelAndView model = new ModelAndView("searchuser");
		List<Object[]> userList = userService.findUsers();
		model.addObject("userList", userList);
		return model;
	}

	@RequestMapping(value = "createUser", method = RequestMethod.GET)
	public ModelAndView createUser() {

		ModelAndView model = new ModelAndView("createuser");
		model.addObject("countryList", getCountries());
		return model;
	}

	@RequestMapping(value = "addUser", method = RequestMethod.POST)
	public @ResponseBody String addUser(@ModelAttribute UserForm userForm) {

		ModelAndView model = new ModelAndView();
		User user = userService.findByExactUserName(userForm.getUserName());
		if (user != null) {
			model.addObject("msg", "User Name already exist");
			model.setViewName("createuser");
		} else {
			userService.createUser(userForm);

		}
		return "Saved";
	}

	@RequestMapping(value = "updateUser", method = RequestMethod.GET)
	public ModelAndView updateUser(@RequestParam(value = "id", required = true) long id) {

		ModelAndView model = new ModelAndView("modifyuser");
		User user = userService.loadUser(id);
		model.addObject("user", user);
		model.addObject("countryList", getCountries());
		model.addObject("stateList", getStates());
		model.addObject("cityList", getCities());
		return model;
	}

	@RequestMapping(value = "modifyUser", method = RequestMethod.POST)
	public @ResponseBody String modifyUser(@ModelAttribute UserForm userForm) {
		userService.updateUser(userForm);
		return "update";
	}

	public Set<Country> getCountries() {
		return cscService.getAllCountries();
	}

	private Set<State> getStates() {
		return cscService.getAllStates();
	}

	private Set<City> getCities() {
		return cscService.getAllCities();
	}

}
