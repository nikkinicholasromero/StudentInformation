package com.studentinformation.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.studentinformation.domainobject.Instructor;
import com.studentinformation.service.InstructorService;

@Controller
public class InstructorController {
	@RequestMapping(value = "/instructors")
	public ModelAndView showInstructors() {
		ModelAndView modelAndView = new ModelAndView("instructor");

		List<Instructor> instructors = InstructorService.getAllInstructors();
		modelAndView.addObject("instructors", instructors);

		return modelAndView;
	}
}