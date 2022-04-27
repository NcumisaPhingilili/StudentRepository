package com.experian.studentapplication.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import com.experian.studentapplication.mapper.StudentRowMapper;
import com.experian.studentapplication.model.Student;

@Repository
public class StudentRepositoryImp implements StudentRepository {

	public StudentRepositoryImp(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<Student> findAll() {
		return namedParameterJdbcTemplate.query("SELECT * from student", new StudentRowMapper());
	}

	@Override
	public void insertStudent(Student student) {
		final String sql = "insert into student(firstName, lastName, DOB, cellphoneNumber, email, score, averageScore) "
				+ "values(:firstName,:lastName,:DOB,:cellphoneNumber,:email,:score,:averageScore)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
				.addValue("firstName", student.getFirstName()).addValue("lastName", student.getLastName())
				.addValue("DOB", student.getDOB()).addValue("cellphoneNumber", student.getCellphoneNumber())
				.addValue("email", student.getEmail()).addValue("score", student.getScore())
				.addValue("averageScore", student.getAverageScore());
		namedParameterJdbcTemplate.update(sql, sqlParameterSource, keyHolder);
	}

	@Override
	public void updateStudent(Student student) {
		final String sql = "update student set firstName=:firstName, lastName=:lastName, DOB=:DOB, cellphoneNumber=:cellphoneNumber, email=:email  where studentNumber=:studentNumber";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
				.addValue("studentNumber", student.getStudentNumber()).addValue("firstName", student.getFirstName())
				.addValue("lastName", student.getLastName()).addValue("DOB", student.getDOB())
				.addValue("cellphoneNumber", student.getCellphoneNumber()).addValue("email", student.getEmail());
		namedParameterJdbcTemplate.update(sql, sqlParameterSource, keyHolder);
	}

	@Override
	public void executeUpdateStudent(Student student) {
		final String sql = "update student set firstName=:firstName, lastName=:lastName, DOB=:DOB, cellphoneNumber=:cellphoneNumber, email=:email  where studentNumber=:studentNumber";

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("studentNumber", student.getStudentNumber());
		map.put("firstName", student.getFirstName());
		map.put("lastName", student.getLastName());
		map.put("DOB", student.getDOB());
		map.put("cellphoneNumber", student.getCellphoneNumber());
		map.put("email", student.getEmail());

		namedParameterJdbcTemplate.execute(sql, map, new PreparedStatementCallback<Object>() {
			@Override
			public Object doInPreparedStatement(PreparedStatement preparedStatement)
					throws SQLException, DataAccessException {
				return preparedStatement.executeUpdate();
			}
		});

	}

	@Override
	public void deleteStudent(Student student) {
		final String sql = "delete from student where studentNumber=:studentNumber";

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("studentNumber", student.getStudentNumber());

		namedParameterJdbcTemplate.execute(sql, map, new PreparedStatementCallback<Object>() {
			@Override
			public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				return ps.executeUpdate();
			}
		});

	}

	@Override
	public List<Student> searchStudentById(Student student) {
		final String sql = "SELECT * from student where studentNumber=:studentNumber";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("studentNumber", student.getStudentNumber());
		return namedParameterJdbcTemplate.query(sql, map, new StudentRowMapper());
	}

	@Override
	public List<Student> searchStudentByFirstName(Student student) {
		final String sql = "SELECT * from student where firstName=:firstName";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("firstName", student.getFirstName());
		return namedParameterJdbcTemplate.query(sql, map, new StudentRowMapper());
	}

	@Override
	public List<Student> searchStudentByLastName(Student student) {
		final String sql = "SELECT * from student where lastName=:lastName";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("lastName", student.getLastName());
		return namedParameterJdbcTemplate.query(sql, map, new StudentRowMapper());
	}

	@Override
	public List<Student> searchStudentByEmail(Student student) {
		final String sql = "SELECT * from student where email=:email";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("email", student.getEmail());
		return namedParameterJdbcTemplate.query(sql, map, new StudentRowMapper());
	}

	@Override
	public void insertStudentScore(Student student) {
		final String sql = "insert into studentscores(studentnumber, score) " + "values(:studentnumber,:score)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
				.addValue("studentnumber", student.getStudentNumber()).addValue("score", student.getScore());
		namedParameterJdbcTemplate.update(sql, sqlParameterSource, keyHolder);

	}
}