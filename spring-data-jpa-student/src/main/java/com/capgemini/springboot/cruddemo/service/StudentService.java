package com.capgemini.springboot.cruddemo.service;

import java.util.List;

import com.capgemini.springboot.cruddemo.entity.Student;

public interface StudentService {

	public List<Student> findAllStudents();

	public Student findStudentById(int id);

	public void save(Student student);

	public void deleteById(int id);
}
