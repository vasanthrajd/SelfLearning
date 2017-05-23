package com.springcustom.controller;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDAO {
	JdbcTemplate template;
	public void setTemplate(JdbcTemplate template){
		this.template=template;
	}
	
	public int save(Employee emp){
		String sql="insert into Employee (name, salary, designation) values ('"+emp.getName()+"','"+emp.getSalary()+"','"+emp.getDesignation()+"')";
		return template.update(sql);
	}
	

}
