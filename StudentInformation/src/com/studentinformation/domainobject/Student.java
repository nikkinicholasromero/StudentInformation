package com.studentinformation.domainobject;

public class Student {
	private int id;
	private String studentId;
	private String firstName;
	private String middleName;
	private String lastName;
	
	public Student() {
	}
	
	public int getId() {
		return id;
	}
	public String getStudentId() {
		return studentId;
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
	public void setStudentId(String studentId) {
		this.studentId = studentId;
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
		string.append("Student ID : " + id + "\n");
		string.append("Student Student ID : " + studentId + "\n");
		string.append("Student First Name : " + firstName + "\n");
		string.append("Student Middle Name : " + middleName + "\n");
		string.append("Student Last Name : " + lastName + "\n");
		return string.toString();
	}
}