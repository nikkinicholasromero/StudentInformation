package com.studentinformation.service;

import java.util.List;

import com.studentinformation.beanfactory.BeanFactory;
import com.studentinformation.dao.StudentDAO;
import com.studentinformation.domainobject.Student;

public final class StudentService {
	private StudentService() {
	}
	
	public static List<Student> getAllStudents() {
		StudentDAO dao = BeanFactory.getStudentDAO();
		return dao.getAllStudents();
	}
}
