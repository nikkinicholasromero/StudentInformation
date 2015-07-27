package com.studentinformation.domainobject;

public class Subject {
	private int id;
	private String subjectCode;
	private String title;

	public Subject() {
	}

	public int getId() {
		return id;
	}
	public String getSubjectCode() {
		return subjectCode;
	}
	public String getTitle() {
		return title;
	}

	public void setId(int id) {
		this.id = id;
	}
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("Subject ID : " + id + "\n");
		string.append("Subject Subject Code : " + subjectCode + "\n");
		string.append("Subject Title : " + title + "\n");
		return string.toString();
	}
}