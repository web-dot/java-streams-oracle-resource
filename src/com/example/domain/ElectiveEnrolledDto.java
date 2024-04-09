package com.example.domain;

import java.util.List;

public class ElectiveEnrolledDto {
	private String courseCode;
	private List<ElectiveEnrolledStudentDTO> enrolledStudents;
	
	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public ElectiveEnrolledDto(List<ElectiveEnrolledStudentDTO> enrolledStudens) {
		this.enrolledStudents = enrolledStudens;
	}

	public List<ElectiveEnrolledStudentDTO> getEnrolledStudents() {
		return enrolledStudents;
	}

	public void setEnrolledStudents(List<ElectiveEnrolledStudentDTO> enrolledStudents) {
		this.enrolledStudents = enrolledStudents;
	}
	
}
