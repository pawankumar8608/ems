package com.ems.admin.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ems.admin.dto.UserForm;
import com.ems.admin.service.UserService;
import com.ems.persistence.domain.User;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value= "searchUser", method= RequestMethod.GET)
	public ModelAndView searchUser(){
		
		   ModelAndView model = new ModelAndView("searchuser");
		   List<User> userList = userService.findAllUsers();
		   model.addObject("userList", userList);
		   return model;
	}
	
	@RequestMapping(value= "createUser", method= RequestMethod.GET)
	public ModelAndView createUser(){
		
		   ModelAndView model = new ModelAndView("createuser");
		   return model;
	}
	
	@RequestMapping(value= "addUser", method= RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute UserForm userForm){
		
		   ModelAndView model = new ModelAndView();
		   User user = userService.findByExactUserName(userForm.getUserName());
		   if(user != null){
			   model.addObject("msg", "User Name already exist");
			   model.setViewName("createuser");
		   }else{
		        userService.createUser(userForm);
		   }
		     return model;	
	}
	
	
}
