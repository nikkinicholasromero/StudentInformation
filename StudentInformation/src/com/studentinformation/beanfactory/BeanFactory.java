package com.studentinformation.beanfactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.studentinformation.dao.InstructorDAO;
import com.studentinformation.dao.RoomDAO;
import com.studentinformation.dao.StudentDAO;
import com.studentinformation.dao.SubjectDAO;

public final class BeanFactory {
	private static ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	
	private BeanFactory() {
		//
	}
	
	public static StudentDAO getStudentDAO() {
		return context.getBean(StudentDAO.class, "studentDAO");
	}
	public static InstructorDAO getInstructorDAO() {
		return context.getBean(InstructorDAO.class, "instructorDAO");
	}
	public static SubjectDAO getSubjectDAO() {
		return context.getBean(SubjectDAO.class, "subjectDAO");
	}
	public static RoomDAO getRoomDAO() {
		return context.getBean(RoomDAO.class, "roomDAO");
	}
}
