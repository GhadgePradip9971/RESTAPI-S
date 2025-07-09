package com.web.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.model.Employee;

public interface IEmployeeRepositiory extends JpaRepository<Employee, Integer> {

}
