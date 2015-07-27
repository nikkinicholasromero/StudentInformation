package com.studentinformation.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.studentinformation.domainobject.Subject;
import com.studentinformation.service.SubjectService;

@Controller
public class SubjectController {
	@RequestMapping(value = "/subjects")
	public ModelAndView showSubjects() {
		ModelAndView modelAndView = new ModelAndView("subject");

		List<Subject> subjects = SubjectService.getAllSubjects();
		modelAndView.addObject("subjects", subjects);

		return modelAndView;
	}
}