package com.nt.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
	private Integer empId;
	private String empName;
	private String[] favColor;
	private List<String> nickNames;
	private Set<Long> phones;
	private Map<String,Long> idDetails;
	private boolean vaccinated;
	private LocalDateTime dob;
	//Has A property
	private Company cmpDetails;
	
	
	
	

}
