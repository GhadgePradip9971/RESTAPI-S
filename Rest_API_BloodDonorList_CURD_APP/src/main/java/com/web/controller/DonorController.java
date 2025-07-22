package com.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.entity.Donor;
import com.web.service.DonorServiceImpl;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/DonorApi")
public class DonorController {
	
	@Autowired
	private DonorServiceImpl donorservice;
	
	@PostMapping("/data")
	public ResponseEntity<Donor> addDonor(@Valid @RequestBody  Donor donor){
		
		return new ResponseEntity<Donor>(donorservice.addDonor(donor),HttpStatus.OK);
		
	}
	
	
	@GetMapping("/getAllList")
	public ResponseEntity<List<Donor>> getAllDonor(){
		return new ResponseEntity<List<Donor>>(donorservice.getAllDonor(),HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Donor> getDonorById(@PathVariable Long id){
		return new ResponseEntity<Donor>(donorservice.getDonorById(id),HttpStatus.OK);
	}
	
	@PostMapping("/update/{id}")
	public ResponseEntity<Donor> updateDonor(@PathVariable Long id,@RequestBody Donor donor){
		
		return new ResponseEntity<Donor>(donorservice.updateDononr(id, donor),HttpStatus.OK);
		
	}
	
	
	@DeleteMapping("/delete/{id}")
	ResponseEntity<String > deleteDonor(@PathVariable Long id){
		donorservice.deleteDonor(id);
		return new ResponseEntity<String>("Donor with ID " + id + " deleted successfully", HttpStatus.OK);
		
	}
	
	
	
	

}
