package com.ems.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthenticationController {
	
	@RequestMapping(value= "/login", method = RequestMethod.GET)
	public ModelAndView login(
		   @RequestParam(value = "error", required=false) String error,
		   @RequestParam(value = "logout", required=false) String logout){
		
		   ModelAndView model = new ModelAndView();
		   if(null != error){
			   model.addObject("error", "Invalid UserName or Password!");
		   }
		   if(null != logout){
			   model.addObject("logout", "You have been logged out successfully"); 
		   }
		   model.setViewName("login");
		   return model;
	}
	
	@RequestMapping(value= {"/", "/welcome**"}, method = RequestMethod.GET)
	public ModelAndView welcomePage(){
		
		   ModelAndView model = new ModelAndView();
		   model.setViewName("dashboard");
		   return model;
	}
	
	@RequestMapping(value= {"/logout"}, method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest req, HttpServletResponse res){
		
		   Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		   if(null != auth){
			   new SecurityContextLogoutHandler().logout(req, res, auth);
		   }
			   
		   return "redirect:/login?logout";
	}
	


}
