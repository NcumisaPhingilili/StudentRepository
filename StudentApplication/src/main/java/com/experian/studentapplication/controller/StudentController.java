package com.experian.studentapplication.controller;

import java.util.List;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.experian.studentapplication.model.Student;
import com.experian.studentapplication.service.StudentService;

@RestController
@RequestMapping("/experianApp")
public class StudentController {

	@Resource
	StudentService studentService;

	Logger logger = LoggerFactory.getLogger(StudentController.class);

	@GetMapping(value = "/studentList")
	public List<Student> getStudents() {
		return studentService.findAll();
	}

	@PostMapping(value = "/createStudent")
	public void createStudent(@RequestBody Student student) {
		if (student.getFirstName() != null && !student.getFirstName().equals("") && student.getLastName() != null
				&& !student.getLastName().equals("")) {
			studentService.insertStudent(student);
			logger.info("Student Created Successfully");

		} else {
			logger.error("Student Name and Surname is mandatory");
		}
	}

	@PutMapping(value = "/updateStudent")
	public void updateStudent(@RequestBody Student student) {
		studentService.updateStudent(student);
		logger.info("Student Updated Successfully");
	}

	@PutMapping(value = "/executeUpdateStudent")
	public void executeUpdateStudent(@RequestBody Student student) {
		studentService.executeUpdateStudent(student);
		logger.info("Student Updated Successfully");
	}

	@DeleteMapping(value = "/deleteStudentById")
	public void deleteStudent(@RequestBody Student student) {
		studentService.deleteStudent(student);
		logger.info("Student Deleted Successfully");
	}

	@GetMapping(value = "/searchStudentById")
	public List<Student> searchStudentById(@RequestBody Student student) {
		return studentService.searchStudentById(student);
	}

	@GetMapping(value = "/searchStudentByName")
	public List<Student> searchStudentByName(@RequestBody Student student) {
		return studentService.searchStudentByFirstName(student);
	}

	@GetMapping(value = "/searchStudentBySurname")
	public List<Student> searchStudentBySurname(@RequestBody Student student) {
		return studentService.searchStudentByLastName(student);
	}

	@GetMapping(value = "/searchStudentByEmail")
	public List<Student> searchStudentByEmail(@RequestBody Student student) {
		return studentService.searchStudentByEmail(student);
	}

	@PostMapping(value = "/studentLatestScore")
	public void insertStudentLatestScore(@RequestBody Student student) {
		List<Student> list = studentService.findAll();
		boolean found = false;
		if (!list.isEmpty() && list.size() != 0) {
			for (Student stud : list) {
				if (stud.getStudentNumber() == student.getStudentNumber()) {
					found = true;
				}
			}
		}
		if (student.getScore() >= 0 && student.getScore() <= 100 && found == true) {
			studentService.insertStudentScore(student);
		} else {
			logger.error("Student’s score cannot be less than zero or more than 100");
			logger.error("Student’s Number does not exist, Please only add latest score of an existing student.");
		}
	}
}