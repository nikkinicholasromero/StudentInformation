package com.studentinformation.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.studentinformation.domainobject.Room;
import com.studentinformation.service.RoomService;

@Controller
public class RoomController {
	@RequestMapping(value = "/rooms")
	public ModelAndView showRooms() {
		ModelAndView modelAndView = new ModelAndView("room");

		List<Room> rooms = RoomService.getAllRooms();
		modelAndView.addObject("rooms", rooms);

		return modelAndView;
	}
}