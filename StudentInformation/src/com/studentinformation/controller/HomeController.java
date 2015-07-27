package com.studentinformation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping(value = "/")
	public String showDefaultHome() {
		return "home";
	}
	@RequestMapping(value = "/home")
	public String showHome() {
		return "home";
	}
}