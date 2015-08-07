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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.studentinformation.domainobject.Room;
import com.studentinformation.json.JSONUtility;
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
	public @ResponseBody void addNewRoom(HttpServletResponse response, @ModelAttribute("room") Room room) throws IOException {
		RoomService.addRoom(room);
	}
	
	@RequestMapping(value = "/getRoomByRoomCode",  method = RequestMethod.POST)
	public @ResponseBody String getRoomByRoomCode(@RequestParam("roomCode") String roomCode) throws JsonProcessingException {
		Room room = RoomService.getRoomByRoomCode(roomCode);
		return JSONUtility.parseJSON(room);
	}
	
	@RequestMapping(value = "/deleteRoom", method=RequestMethod.POST)
	public @ResponseBody void deleteRoom(@RequestParam("deleteId") int deleteId) {
		RoomService.deleteRoomById(deleteId);
	}
}