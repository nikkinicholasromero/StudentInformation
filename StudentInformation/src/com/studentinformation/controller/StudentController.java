
package com.studentinformation.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.studentinformation.domainobject.Student;
import com.studentinformation.json.JSONUtility;
import com.studentinformation.service.StudentService;

@Controller
@RestController
public class StudentController {
	@RequestMapping(value = "/students")
	public ModelAndView showStudents() {
		ModelAndView modelAndView = new ModelAndView("student");

		List<Student> students = StudentService.getAllStudents();
		modelAndView.addObject("students", students);

		return modelAndView;
	}

	@RequestMapping(value = "/addNewStudent", method = RequestMethod.POST)
	public @ResponseBody void addNewStudent(HttpServletResponse response, @ModelAttribute("student") Student student) throws IOException {
		StudentService.addStudent(student);
	}
	
	@RequestMapping(value = "/getStudentByStudentId", method = RequestMethod.POST)
	public @ResponseBody String getStudentByStudentId(@RequestParam("studentId") String studentId) throws JsonProcessingException {
		Student student = StudentService.getStudentByStudentId(studentId);
		return JSONUtility.parseJSON(student);
	}

	@RequestMapping(value = "/deleteStudent", method = RequestMethod.POST)
	public @ResponseBody void deleteStudent(@RequestParam("deleteId") int deleteId) {
		StudentService.deleteStudentById(deleteId);
	}

	
}