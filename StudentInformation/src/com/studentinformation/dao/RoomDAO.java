package com.studentinformation.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.studentinformation.domainobject.Room;

public class RoomDAO implements RowMapper<Room> {
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public Room getRoomById(int id) {
		String SQL = "select * from room where id = ?";
		Room room = jdbcTemplate.queryForObject(SQL, new Object[] { id }, this);
		return room;
	}

	public Room getRoomByROomtCode(String roomCode) {
		String SQL = "select * from room where room_code = ?";
		Room room = jdbcTemplate.queryForObject(SQL, new Object[] { roomCode }, this);
		return room;
	}

	public List<Room> getAllRooms() {
		String SQL = "select * from room";
		List<Room> rooms = jdbcTemplate.query(SQL, this);
		return rooms;
	}

	public void addRoom(Room room) {
		String SQL = "insert into room(room_code, name) values (?, ?)";
		jdbcTemplate.update(SQL, room.getRoomCode(), room.getName());
	}

	@Override
	public Room mapRow(ResultSet rs, int rowNum) throws SQLException {
		Room room = new Room();
		room.setId(rs.getInt("id"));
		room.setRoomCode(rs.getString("room_code"));
		room.setName(rs.getString("name"));
		return room;
	}
}
