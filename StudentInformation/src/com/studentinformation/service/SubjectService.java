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
	
	public static void addSubject(Subject subject) {
		SubjectDAO dao = BeanFactory.getSubjectDAO();
		dao.addSubject(subject);
	}
	
	public static void deleteSubjectById(int id) {
		SubjectDAO dao = BeanFactory.getSubjectDAO();
		dao.deleteSubjectById(id);
	}
	
	
}
