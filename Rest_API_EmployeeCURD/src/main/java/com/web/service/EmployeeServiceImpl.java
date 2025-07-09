package com.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.model.Employee;
import com.web.repositiory.IEmployeeRepositiory;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private IEmployeeRepositiory repo;

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return repo.save(employee);
	}

	@Override
	public Optional<Employee> findById(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public List<Employee> FindAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Employee updateEmployee( Employee employee) {
		// TODO Auto-generated method stub
		return repo.save(employee);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		  
		repo.deleteById(id);
	}

	
}
