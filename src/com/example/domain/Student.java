package com.example.domain;

import java.util.List;

public class Student {
	private String id;
    private String usn;
    private List<CourseScore> courseScores;
    private boolean backlogCourse;

    public Student(String usn, List<CourseScore> courseScores) {
        this.usn = usn;
        this.courseScores = courseScores;
        this.backlogCourse = false;
    }
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isBacklogCourse() {
		return backlogCourse;
	}
	public void setUsn(String usn) {
		this.usn = usn;
	}
	public void setCourseScores(List<CourseScore> courseScores) {
		this.courseScores = courseScores;
	}
	public String getUsn() {
        return usn;
    }
    public List<CourseScore> getCourseScores() {
        return courseScores;
    }
    public boolean hasBacklogCourse() {
        return backlogCourse;
    }
    public void setBacklogCourse(boolean backlogCourse) {
        this.backlogCourse = backlogCourse;
    }
}
