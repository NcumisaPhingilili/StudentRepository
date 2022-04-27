package com.experian.studentapplication.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.experian.studentapplication.model.Student;

public class StudentRowMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet resultSet, int arg1) throws SQLException {
		Student student = new Student();
		student.setStudentNumber(resultSet.getInt("studentnumber"));
		student.setFirstName(resultSet.getString("firstname"));
		student.setLastName(resultSet.getString("lastname"));
		student.setDOB(resultSet.getDate("dob"));
		student.setCellphoneNumber(resultSet.getString("cellphonenumber"));
		student.setEmail(resultSet.getString("email"));
		student.setScore(resultSet.getInt("score"));
		student.setAverageScore(resultSet.getDouble("averagescore"));
		return student;
	}
}