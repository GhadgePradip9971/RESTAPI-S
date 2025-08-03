package com.web.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Tourist")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tourist {
	@Id
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tourist_seq_gen")
    @SequenceGenerator(name = "tourist_seq_gen", sequenceName = "tourist_seq", allocationSize = 1) 
	private Integer tid;
@Column(length=20)
	@NotNull
 private String name;
@Column(length=20)
@NotNull
 private String city;
@Column(length=20)
@NotNull

 private String packageType;
@NotNull
 private Double budget;
 
 
 

}
