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
import com.studentinformation.domainobject.Instructor;
import com.studentinformation.json.JSONUtility;
import com.studentinformation.service.InstructorService;

@Controller
@RestController
public class InstructorController {
	@RequestMapping(value = "/instructors")
	public ModelAndView showInstructors() {
		ModelAndView modelAndView = new ModelAndView("instructor");

		List<Instructor> instructors = InstructorService.getAllInstructors();
		modelAndView.addObject("instructors", instructors);

		return modelAndView;
	}
	
	@RequestMapping(value = "/addNewInstructor", method=RequestMethod.POST)
	public @ResponseBody void addNewInstructor(HttpServletResponse response, @ModelAttribute("instructor") Instructor instructor) throws IOException {
		InstructorService.addInstructor(instructor);
	}
	
	@RequestMapping(value = "/deleteInstructor", method=RequestMethod.POST)
	public @ResponseBody void deleteInstructor(@RequestParam("deleteId") int deleteId) {
		InstructorService.deleteInstructorById(deleteId);
	}
	
	@RequestMapping(value = "/getInstructorByInstructorId", method = RequestMethod.POST)
	public @ResponseBody String getInstructorByInstructorId(@RequestParam("instructorId") String instructorId) throws JsonProcessingException {
		Instructor instructor = InstructorService.getInstructorByInstructorId(instructorId);
		return JSONUtility.parseJSON(instructor);
	}
}