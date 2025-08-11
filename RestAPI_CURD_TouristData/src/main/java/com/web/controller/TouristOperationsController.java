package com.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.Tourist;
import com.web.service.ITouristMgmService;

@RestController
@RequestMapping("/tourist")
public class TouristOperationsController {
	
	@Autowired
	private ITouristMgmService service;
	
	@PostMapping("/register")
	public ResponseEntity<String> enrollTourist(@RequestBody Tourist Tourist){
		try {
			
		
		String regMsg=service.registerTourist(Tourist);
		
		return new ResponseEntity<String>(regMsg,HttpStatus.CREATED);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Problem in Tourist Enrollment",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Tourist>> displayTourist(){
		
		try {
		List<Tourist> list=service.fetchAllTourist();
		return new ResponseEntity<List<Tourist>>(list,HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<Tourist>>(/*"Problem In Fetching result"*/HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/find/{tid}")
	public ResponseEntity<Tourist>  displauTouristById(@PathVariable Integer tid){
		try{
			Tourist tourist=service.fetchTouristById(tid);
		
		return new ResponseEntity<Tourist>(tourist,HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Tourist>(/* e.getMessage(), */HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<String> modifyTourist(@RequestBody Tourist tourist){
		
		try {
			String msg=service.updateTouristDetails(tourist);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	
	@DeleteMapping("/delete/{tid}")
	public ResponseEntity<String> removeStudent(@PathVariable Integer tid){
		
		try {
			String msg = service.deleteTourist(tid);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	@PatchMapping("/budgetmodify/{tid}/{hikePercent}")
	public ResponseEntity<String> modifyTouristBudgetById(@PathVariable Integer tid ,@PathVariable Double hikePercent ){
		
		try {
			String msg=service.updateTouristBudgetBYId(tid, hikePercent);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		} catch (Exception  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	

}
