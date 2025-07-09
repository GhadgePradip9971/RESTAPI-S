package com.web.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.model.Student;

public interface IStudentrepositiory extends JpaRepository<Student, Integer> {

}

