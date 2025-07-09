package com.web.service;

import java.util.List;
import java.util.Optional;

import com.web.model.Employee;

public interface IEmployeeService {

	
	Employee saveEmployee(Employee employee);
	Optional <Employee>  findById(Integer id);
	List<Employee> FindAll();
	Employee updateEmployee(Employee employee);
	void deleteById(Integer id);
	
	
}

