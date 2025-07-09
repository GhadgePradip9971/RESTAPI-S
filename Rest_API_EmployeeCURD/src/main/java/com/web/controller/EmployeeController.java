package com.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.exception.RecordNotFoundException;
import com.web.model.Employee;
import com.web.service.EmployeeServiceImpl;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/Employee")
@Slf4j
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl service;
	
	
	@PostMapping("/save")
	public ResponseEntity<Employee> save(@Valid @RequestBody Employee employee){
		return ResponseEntity.ok(service.saveEmployee(employee));
			
	}
	@GetMapping("/findbyid/{id}")
	public ResponseEntity<Optional<Employee>> findbyid(@PathVariable Integer id){
		return ResponseEntity.ok(service.findById(id));
		
	}
	

	@GetMapping("/findAll")
	public ResponseEntity<List <Employee>> findAllEmployee(){
		List<Employee> employee=service.FindAll();
		return ResponseEntity.ok(employee);
	}

	
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateUser(@PathVariable Integer id, @Valid @RequestBody Employee employee) {

	    Employee emp = service.findById(id).orElseThrow(() -> new RecordNotFoundException("Employee ID " + id + " does not exist"));

	    emp.setEmpName(employee.getEmpName());
	    emp.setEmpSalary(employee.getEmpSalary());
	    // Set other fields if needed

	    Employee updatedEmp = service.updateEmployee(emp);
	    return ResponseEntity.ok(updatedEmp);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteBYId(@PathVariable Integer id) {
		
		service.deleteById(id);
		return "employee deleted succesfully";
		}
	
}
