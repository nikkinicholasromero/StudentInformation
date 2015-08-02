package com.studentinformation.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.studentinformation.domainobject.Student;

public class StudentDAO implements RowMapper<Student> {
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public Student getStudentById(int id) {
		String SQL = "select * from student where id = ?";
		Student student = jdbcTemplate.queryForObject(SQL, new Object[] { id }, this);
		return student;
	}

	public Student getStudentByStudentId(String studentId) {
		String SQL = "select * from student where student_id = ?";
		Student student = jdbcTemplate.queryForObject(SQL, new Object[] { studentId }, this);
		return student;
	}

	public List<Student> getAllStudents() {
		String SQL = "select * from student";
		List<Student> students = jdbcTemplate.query(SQL, this);
		return students;
	}

	public void addStudent(Student student) {
		String SQL = "insert into student (student_id, first_name, middle_name, last_name) values (?, ?, ?, ?)";
		jdbcTemplate.update(SQL, student.getStudentId(), student.getFirstName(), student.getMiddleName(), student.getLastName());
	}

	public void deleteStudentById(int id) {
		String SQL = "delete from student where id = ?";
		jdbcTemplate.update(SQL, id);
	}
	
	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		student.setId(rs.getInt("id"));
		student.setStudentId(rs.getString("student_id"));
		student.setFirstName(rs.getString("first_name"));
		student.setMiddleName(rs.getString("middle_name"));
		student.setLastName(rs.getString("last_name"));
		return student;
	}
}