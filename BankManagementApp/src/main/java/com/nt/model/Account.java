package com.nt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table (name="Account")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long account_number;
    @NotBlank(message = "Account holder name is mandatory")
    @Size(min = 3, max = 50, message = "Account holder name must be between 3 and 50 characters")
    @NotNull
    private String account_holder_name;
    @NotNull(message = "Account balance is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Account balance must be greater than 0")

    private Double account_balance;
	
	

}
