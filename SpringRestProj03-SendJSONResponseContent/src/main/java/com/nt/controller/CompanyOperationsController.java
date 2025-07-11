package com.nt.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Company;
import com.nt.model.Employee;

@RestController
@RequestMapping("/Company")
public class CompanyOperationsController {
	
	/*@GetMapping("/get")
	public ResponseEntity<Company> showCompanyDetails(){
	Company c = new Company("tcs", "pune", 200, 450450.00, "it");
	
		//create and return entity Response Entity object having model class object as the response body
		return new ResponseEntity<Company>(c,HttpStatus.OK);
		
		
	}*/
	
	/*	@GetMapping("/geting")
		public Company  showCompanyDetails(){
		Company c = new Company("tcs", "pune", 200, 450450.00, "it");
		//create and return model class object
			return c;
			
			
		}*/
	@GetMapping("/Employee")
	public ResponseEntity<Employee> showEmpDetails(){
		Company company = new Company("tcs", "pune", 200, 450450.00, "it");

        Employee emp = new Employee(
                1001,
                "raja",
                new String[]{"red", "green", "blue"},
                List.of("king", "maharaja", "sultan"),  // Corrected List.of()
                Set.of(9999999L, 454555L),              // Corrected Set.of()
                Map.of("uidai", 99453L, "voterid", 34566L), // Corrected Map.of()
                false,
                LocalDateTime.of(1990, 10, 10, 2, 30),
                company  // No semicolon here
        );  // No semicolon here
        
        return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	
	}	
	
	
	
	
	
	

}
