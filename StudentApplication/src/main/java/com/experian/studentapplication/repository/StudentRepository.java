package com.experian.studentapplication.repository;

import java.util.List;
import com.experian.studentapplication.model.Student;

public interface StudentRepository {

	public List<Student> findAll();

	public void insertStudent(Student student);

	public void updateStudent(Student student);

	public void executeUpdateStudent(Student student);

	public void deleteStudent(Student student);
	
	public List<Student> searchStudentById(Student student);
	
	public List<Student> searchStudentByFirstName(Student student);
	
	public List<Student> searchStudentByLastName(Student student);
	
	public List<Student> searchStudentByEmail(Student student);
	
	public void insertStudentScore(Student student);
}
