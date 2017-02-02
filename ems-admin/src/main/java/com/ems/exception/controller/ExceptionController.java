package com.ems.exception.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(Exception.class)
	public ModelAndView exceptionHandling(){
		   ModelAndView model = new ModelAndView("error");
		   return model;
	}

}
