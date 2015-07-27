package com.studentinformation.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.studentinformation.domainobject.Student;
import com.studentinformation.service.StudentService;

@Controller
public class StudentController {
	@RequestMapping(value = "/students")
	public ModelAndView showStudents() {
		ModelAndView modelAndView = new ModelAndView("student");

		List<Student> students = StudentService.getAllStudents();
		modelAndView.addObject("students", students);

		return modelAndView;
	}
}