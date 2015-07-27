package com.studentinformation.domainobject;

public class Room {
	private int id;
	private String roomCode;
	private String name;

	public Room() {
	}

	public int getId() {
		return id;
	}
	public String getRoomCode() {
		return roomCode;
	}
	public String getName() {
		return name;
	}

	public void setId(int id) {
		this.id = id;
	}
	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("Room ID : " + id + "\n");
		string.append("Room Room Code : " + roomCode + "\n");
		string.append("Room Name : " + name + "\n");
		return string.toString();
	}
}