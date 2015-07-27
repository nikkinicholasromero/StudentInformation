package com.studentinformation.domainobject;

public class Instructor {
	private int id;
	private String instructorId;
	private String firstName;
	private String middleName;
	private String lastName;

	public Instructor() {
	}

	public int getId() {
		return id;
	}
	public String getInstructorId() {
		return instructorId;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public String getLastName() {
		return lastName;
	}

	public void setId(int id) {
		this.id = id;
	}
	public void setInstructorId(String instructorId) {
		this.instructorId = instructorId;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("Instructor ID : " + id + "\n");
		string.append("Instructor Instructor ID : " + instructorId + "\n");
		string.append("Instructor First Name : " + firstName + "\n");
		string.append("Instructor Middle Name : " + middleName + "\n");
		string.append("Instructor Last Name : " + lastName + "\n");
		return string.toString();
	}
}