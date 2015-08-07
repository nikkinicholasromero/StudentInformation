package com.studentinformation.service;

import java.util.List;

import com.studentinformation.beanfactory.BeanFactory;
import com.studentinformation.dao.RoomDAO;
import com.studentinformation.domainobject.Room;

public final class RoomService {
	private RoomService() {
	}
	
	public static List<Room> getAllRooms() {
		RoomDAO dao = BeanFactory.getRoomDAO();
		return dao.getAllRooms();
	}
	
	public static void addRoom(Room room) {
		RoomDAO dao = BeanFactory.getRoomDAO();
		dao.addRoom(room);
	}
	
	public static void deleteRoomById(int id) {
		RoomDAO dao = BeanFactory.getRoomDAO();
		dao.deleteRoomById(id);
	}
	
	public static Room getRoomByRoomCode(String roomCode) {
		RoomDAO dao = BeanFactory.getRoomDAO();
		return dao.getRoomByRoomCode(roomCode);
	}
}
