package com.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Donor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull(message = "Must Enter Name")
	private String name;
	@Min(value = 18,message="Age Should Be At lest 18")
	@Max(value = 65,message="Age Should Not Exceed 65")
	private Integer age;
	@Pattern(regexp ="^(?i)(A|B|AB|O)[+-]$",message = "Invalid Blood group")
	private  String bloodgroup;

}
