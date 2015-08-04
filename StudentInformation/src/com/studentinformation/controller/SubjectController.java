package com.studentinformation.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	@RequestMapping(value = "/addNewSubject", method = RequestMethod.POST)
	public ModelAndView addNewSubject(@ModelAttribute("subject") Subject subject) {
		ModelAndView modelAndView = new ModelAndView("subject");

		SubjectService.addSubject(subject);

		List<Subject> subjects = SubjectService.getAllSubjects();
		modelAndView.addObject("subjects", subjects);

		return modelAndView;
	}
	
	@RequestMapping(value = "/deleteSubject", method=RequestMethod.POST)
	public ModelAndView deleteRoom(@RequestParam("deleteId") int deleteId) {
		ModelAndView modelAndView = new ModelAndView("subject");
		
		SubjectService.deleteSubjectById(deleteId);

		List<Subject> subjects = SubjectService.getAllSubjects();
		modelAndView.addObject("subjects", subjects);

		return modelAndView;
	}
}