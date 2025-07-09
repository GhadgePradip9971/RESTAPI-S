package com.web.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name="Emp")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_seq1_gen")
    @SequenceGenerator(name = "emp_seq1_gen", sequenceName = "emp_seq1", allocationSize = 1)
	private Integer empId;
    @NotBlank(message = "Employee name must not be blank")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Employee name must contain only letters and spaces")
	private String empName;
    

    @Positive(message = "Salary must be greater than zero")
	private Double empSalary;
	
	
	

}
