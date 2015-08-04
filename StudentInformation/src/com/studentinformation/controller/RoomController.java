package com.studentinformation.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	@RequestMapping(value = "/addNewRoom", method = RequestMethod.POST)
	public ModelAndView addNewRoom(@ModelAttribute("room") Room room) {
		ModelAndView modelAndView = new ModelAndView("room");

		RoomService.addRoom(room);

		List<Room> rooms = RoomService.getAllRooms();
		modelAndView.addObject("rooms", rooms);

		return modelAndView;
	}
	
	@RequestMapping(value = "/deleteRoom", method=RequestMethod.POST)
	public ModelAndView deleteRoom(@RequestParam("deleteId") int deleteId) {
		ModelAndView modelAndView = new ModelAndView("room");
		
		RoomService.deleteRoomById(deleteId);

		List<Room> rooms = RoomService.getAllRooms();
		modelAndView.addObject("rooms", rooms);

		return modelAndView;
	}
}