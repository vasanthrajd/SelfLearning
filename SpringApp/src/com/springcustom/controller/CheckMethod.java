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
		
		if(password.equals("Vasanthraj")){
			String userNote="Welcome you are Logged in as :"+name;
			return new ModelAndView("admin","showSuccess",userNote);
		}else{
			String userNote="Please Provide propery password";
			return new ModelAndView("Error","showFailure",userNote);
		}
	}
}
