package com.studentinformation.service;

import java.util.List;

import com.studentinformation.beanfactory.BeanFactory;
import com.studentinformation.dao.SubjectDAO;
import com.studentinformation.domainobject.Subject;

public final class SubjectService {
	private SubjectService() {
	}
	
	public static List<Subject> getAllSubjects() {
		SubjectDAO dao = BeanFactory.getSubjectDAO();
		return dao.getAllSubjects();
	}
}
