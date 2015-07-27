package com.studentinformation.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.studentinformation.domainobject.Instructor;

public class InstructorDAO implements RowMapper<Instructor> {
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public Instructor getInstructorById(int id) {
		String SQL = "select * from instructor where id = ?";
		Instructor instructor = jdbcTemplate.queryForObject(SQL, new Object[] { id }, this);
		return instructor;
	}

	public Instructor getInstructorByInstructorId(String instructorId) {
		String SQL = "select * from instructor where instructor_id = ?";
		Instructor instructor = jdbcTemplate.queryForObject(SQL, new Object[] { instructorId }, this);
		return instructor;
	}

	public List<Instructor> getAllInstructors() {
		String SQL = "select * from instructor";
		List<Instructor> instructors = jdbcTemplate.query(SQL, this);
		return instructors;
	}

	@Override
	public Instructor mapRow(ResultSet rs, int rowNum) throws SQLException {
		Instructor instructor = new Instructor();
		instructor.setId(rs.getInt("id"));
		instructor.setInstructorId(rs.getString("instructor_id"));
		instructor.setFirstName(rs.getString("first_name"));
		instructor.setMiddleName(rs.getString("middle_name"));
		instructor.setLastName(rs.getString("last_name"));
		return instructor;
	}
}
