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
}
