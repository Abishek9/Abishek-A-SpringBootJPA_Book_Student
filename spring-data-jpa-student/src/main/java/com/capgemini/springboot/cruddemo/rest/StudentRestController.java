package com.capgemini.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.springboot.cruddemo.entity.Student;
import com.capgemini.springboot.cruddemo.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private StudentService studentService;

	@Autowired
	public StudentRestController(StudentService thestudentService) {
		studentService = thestudentService;
	}

	// expose "/students" to return list of students
	@GetMapping("/students")
	public List<Student> findAllStudents() {

		return studentService.findAllStudents();
	}

	// add mapping for GET /students/{studentId}
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {

		Student student = studentService.findStudentById(studentId);

		if (student == null) {
			throw new RuntimeException("Student Id not found:" + studentId);
		}

		return student;
	}

	// add mapping for POST /students - add new student
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student) {

		// also just in case they pass an id in JSON .... set id to 0
		// this is to force a save of new item .... instead of update
		student.setId(0);

		studentService.save(student);

		return student;
	}

	// add mapping for PUT /students - update student
	@PutMapping("/students")
	public Student updateStudent(@RequestBody Student student) {

		studentService.save(student);
		return student;
	}

	// add mapping for DELETE /students/{studentId} - delete student
	@DeleteMapping("/students/{studentId}")
	public String deleteStudent(@PathVariable int studentId) {

		Student theStudent = studentService.findStudentById(studentId);

		// throw exception if null
		if (theStudent == null) {
			throw new RuntimeException("Student Id not found:" + studentId);
		}
		studentService.deleteById(studentId);

		return "Deleted Student id :" + studentId;

	}
}
