package com.ws.service;

import com.ws.model.Employee;

public class EmployeeServiceImpl {
	
	public  Employee searchEmp(Employee emp){
		Employee empOutput = new Employee();
		empOutput.setName(emp.getName());
		empOutput.setDepartment(emp.getDepartment());
		
		return empOutput;
	}

}
