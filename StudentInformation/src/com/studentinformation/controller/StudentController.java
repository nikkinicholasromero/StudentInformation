package com.studentinformation.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(value = "/addNewStudent", method=RequestMethod.POST)
	public ModelAndView addNewStudent(@ModelAttribute("student") Student student) {
		ModelAndView modelAndView = new ModelAndView("student");
		
		StudentService.addStudent(student);

		List<Student> students = StudentService.getAllStudents();
		modelAndView.addObject("students", students);

		return modelAndView;
	}
	
	@RequestMapping(value = "/deleteStudent", method=RequestMethod.POST)
	public ModelAndView deleteStudent(@RequestParam("deleteId") int deleteId) {
		ModelAndView modelAndView = new ModelAndView("student");
		
		StudentService.deleteStudentById(deleteId);

		List<Student> students = StudentService.getAllStudents();
		modelAndView.addObject("students", students);

		return modelAndView;
	}
}