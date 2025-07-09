package com.web.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Data 
@Entity
@NoArgsConstructor
@Table(name="studentTab")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer rollNo;
	@Column(name="stdName")
	private String name;
	@Column(name="stdPercentage")
	private Float percentage;
	@Column(name="branch")
	private String branch;
	
	
	

}
