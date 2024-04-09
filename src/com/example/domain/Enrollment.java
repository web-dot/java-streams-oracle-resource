package com.example.domain;

import java.util.List;

public class Enrollment {
	
	private List<EnrolledCourse> enrolledCourses;

    public Enrollment(List<EnrolledCourse> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public List<EnrolledCourse> getEnrolledCourses() {
        return enrolledCourses;
    }
}
