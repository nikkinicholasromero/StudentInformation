package com.studentinformation.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.studentinformation.domainobject.Subject;

public class SubjectDAO implements RowMapper<Subject> {
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public Subject getSubjectById(int id) {
		String SQL = "select * from subject where id = ?";
		Subject subject = jdbcTemplate.queryForObject(SQL, new Object[] { id }, this);
		return subject;
	}

	public Subject getSubjectBySubjectCode(String subjectCode) {
		String SQL = "select * from subject where subject_code = ?";
		Subject subject = jdbcTemplate.queryForObject(SQL, new Object[] { subjectCode }, this);
		return subject;
	}

	public List<Subject> getAllSubjects() {
		String SQL = "select * from subject";
		List<Subject> subjects = jdbcTemplate.query(SQL, this);
		return subjects;
	}

	@Override
	public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
		Subject subject = new Subject();
		subject.setId(rs.getInt("id"));
		subject.setSubjectCode(rs.getString("subject_code"));
		subject.setTitle(rs.getString("title"));
		return subject;
	}
}
