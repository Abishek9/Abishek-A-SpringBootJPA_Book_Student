package com.capgemini.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.springboot.cruddemo.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	// no need to write code
}
