package com.example.domain;

public class ElectiveEnrolledStudentDTO {
	
	private String id;
	private String studentId;
	private String studentName;
	private String candidateId;

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ElectiveEnrolledStudentDTO(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentId() {
		return studentId;
	}


	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public String getCandidateId() {
		return candidateId;
	}


	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}
	
	
}
