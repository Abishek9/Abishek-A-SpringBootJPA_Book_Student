package com.capgemini.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.capgemini.springboot.cruddemo.dao.StudentRepository;
import com.capgemini.springboot.cruddemo.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepository;

	@Autowired
	public StudentServiceImpl(StudentRepository thestudentRepository) {
		studentRepository = thestudentRepository;
	}

	@Override
	public List<Student> findAllStudents() {

		return studentRepository.findAll();
	}

	@Override
	public Student findStudentById(int id) {

		Optional<Student> result = studentRepository.findById(id);
		Student book = null;
		if (result.isPresent()) {
			book = result.get();
		} else {
			throw new RuntimeException("Didn't find the Student Id :" + id);
		}

		return book;
	}

	@Override
	public void save(Student student) {
		studentRepository.save(student);
	}

	@Override
	public void deleteById(int id) {
		studentRepository.deleteById(id);
	}

}
