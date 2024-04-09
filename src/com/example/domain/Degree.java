package com.example.domain;

import java.util.List;

public class Degree {
	
	private List<Department> departments;
	
	public Degree(List<Department> departments) {
		this.departments = departments;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}
	
}
