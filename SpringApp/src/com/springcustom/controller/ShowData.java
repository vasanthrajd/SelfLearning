package com.springcustom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShowData {

	@RequestMapping("/data")
	public ModelAndView showDataInfo(){
		String message="<br><div style='text-align:center;'>"+
					   "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
		return new ModelAndView("data", "dataInfo", message);
	}
}
