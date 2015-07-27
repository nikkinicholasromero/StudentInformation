package com.studentinformation.service;

import java.util.List;

import com.studentinformation.beanfactory.BeanFactory;
import com.studentinformation.dao.InstructorDAO;
import com.studentinformation.domainobject.Instructor;

public final class InstructorService {
	private InstructorService() {
	}
	
	public static List<Instructor> getAllInstructors() {
		InstructorDAO dao = BeanFactory.getInstructorDAO();
		return dao.getAllInstructors();
	}
}
