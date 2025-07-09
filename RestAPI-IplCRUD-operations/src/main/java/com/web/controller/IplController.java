package com.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.IplTeam;
import com.web.service.IplTeamServiceImpl;

@RestController
public class IplController {
	
	@Autowired
	IplTeamServiceImpl iplservice;
	
	@PostMapping("/insert")
	public ResponseEntity<IplTeam> insertData(@RequestBody IplTeam iplTeam){
		
		IplTeam savedIplTeam=iplservice.insertData(iplTeam);
		
		return new ResponseEntity<IplTeam>(savedIplTeam,HttpStatus.CREATED);
		
	}
	@GetMapping("/allData")
	public ResponseEntity<List<IplTeam>> getAll(){
		
		List<IplTeam> iplTeams=iplservice.getAllTeams();
		return  ResponseEntity.ok(iplTeams);
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<IplTeam> update(@PathVariable int id,@RequestBody IplTeam iplTeam){
		IplTeam updateTeam=iplservice.updateTeam(id, iplTeam);
		return new ResponseEntity<IplTeam>(updateTeam,HttpStatus.OK);
		
		
	}
	
	
	@DeleteMapping("/{id}")
	
	public ResponseEntity<Map<String,Boolean>> delete(@PathVariable int id){
		iplservice.delete(id);
		Map<String,Boolean> response=new HashMap<String,Boolean>();
		response.put("deletedd", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}

}
