package com.springcustom.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CheckMethod {

	@RequestMapping("/admin")
	public ModelAndView checkMethodAdmin(HttpServletRequest request,HttpServletResponse response){
		String name=request.getParameter("Name");
		String password=request.getParameter("Password");
		String successNote="Welcome you are Logged in as:";
		String failureNote="Please Provide Valid Credentials :";
		if(name.equals("admin")){
			if(password.equals("Vasanthraj")){
				return new ModelAndView("success","showSuccess",successNote + name);
			}else{
				return new ModelAndView("Error","showFailure", failureNote);
			}
		}else{
			
			return new ModelAndView("Error","showFailure",failureNote);
		}
	}
}
