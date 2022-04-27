package com.experian.studentapplication.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import com.experian.studentapplication.model.Student;
import com.experian.studentapplication.repository.StudentRepository;

@Component
public class StudentServiceImpl implements StudentService {
	@Resource
	StudentRepository studentRepository;

	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public void insertStudent(Student student) {
		studentRepository.insertStudent(student);
	}

	@Override
	public void updateStudent(Student student) {
		studentRepository.updateStudent(student);
	}

	@Override
	public void executeUpdateStudent(Student student) {
		studentRepository.executeUpdateStudent(student);
	}

	@Override
	public void deleteStudent(Student student) {
		studentRepository.deleteStudent(student);
	}

	@Override
	public List<Student> searchStudentById(Student student) {
		return studentRepository.searchStudentById(student);
	}

	@Override
	public List<Student> searchStudentByFirstName(Student student) {
		return studentRepository.searchStudentByFirstName(student);
	}

	@Override
	public List<Student> searchStudentByLastName(Student student) {
		return studentRepository.searchStudentByLastName(student);
	}

	@Override
	public List<Student> searchStudentByEmail(Student student) {
		return studentRepository.searchStudentByEmail(student);
	}

	@Override
	public void insertStudentScore(Student student) {
		studentRepository.insertStudentScore(student);
	}
}