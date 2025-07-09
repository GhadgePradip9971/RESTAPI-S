package com.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.Student;
import com.web.repositiory.IStudentrepositiory;

@RestController
public class StudentController {
	
	@Autowired
	IStudentrepositiory repo;
	
	@GetMapping("/student")
	public List<Student> getAllStudent(){
		 
	List<Student> student=repo.findAll();
		return student;
	}
	
	@GetMapping("/student/{id}")
	public Student  getStudent(@PathVariable int id) {
		
		Student student=repo.findById(id).get();
		return student;
		
	}
	
	@PostMapping("/newstudent")
	public void createStudent(@RequestBody Student student) {
		Student saveStd=repo.save(student);
		
	}
	
	@PutMapping("/student/update/{id}")
	public Student updateStudent(@PathVariable int id) {
		Student student=repo.findById(id).get();
		student.setName("rahul");
		student.setPercentage((float) 44.90);
		student.setBranch("cse");
		return student;
		
			
	}
	
	@DeleteMapping("/student/delete/{id}")
	public void deleteStudent(@PathVariable int id) {
		Student student=repo.findById(id).get();
		System.out.println("deletd succesuflly");
		repo.delete(student);
	}

}
