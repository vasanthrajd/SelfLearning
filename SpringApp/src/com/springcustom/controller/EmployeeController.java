package com.springcustom.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeDAO empDao;
	
	@RequestMapping("/employeeForm")
	public ModelAndView addEmployee(){
		return new ModelAndView("AddEmployee", "command", new Employee());
	}
	
	@RequestMapping(value="/saveEmployee", method=RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("emp") Employee employee){
		System.out.println(employee.getName()+"\t"+employee.getDesignation()+"\t"+employee.getSalary());
		empDao.save(employee);
		return new ModelAndView("redirect:/viewEmployeeForm.html");		
	}
	
	@RequestMapping("/viewEmployeeForm")
	public ModelAndView showEmployee(){
			List<Employee> empList=new ArrayList<Employee>();
			empList.add(new Employee(1,"Vasanthraj","Software Developer",150000f));
			return new ModelAndView("ViewEmployee","list",empList);		
	}
	
}
