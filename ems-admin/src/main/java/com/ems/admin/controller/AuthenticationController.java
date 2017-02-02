package com.ems.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.ems.persistence.domain.Administrator;
import com.ems.persistence.domain.User;

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
	
	@RequestMapping(value= {"/", "/welcome"}, method = RequestMethod.GET)
	public ModelAndView welcomePage(HttpServletRequest request){
		
		   ModelAndView model = new ModelAndView();
		   HttpSession session = request.getSession();
		   session.setAttribute("firstName", getFirstName());
		   model.setViewName("dashboard");
		   return model;
	}
	
	private String getFirstName() {
		    Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		    String name = null;
		    if(obj instanceof Administrator)
		    	 name = ((Administrator) obj).getFirstName();
		    else if(obj instanceof User){
		    	 name = ((User) obj).getFirstName();
		    }
		        return name;
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
