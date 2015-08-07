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
	public @ResponseBody void addNewSubject(HttpServletResponse response, @ModelAttribute("subject") Subject subject) throws IOException {
		SubjectService.addSubject(subject);
	}
	
	@RequestMapping(value = "/deleteSubject", method=RequestMethod.POST)
	public @ResponseBody void deleteSubjct(@RequestParam("deleteId") int deleteId) {
		SubjectService.deleteSubjectById(deleteId);
	}
}