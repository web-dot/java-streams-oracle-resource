package com.example.domain;

public class CourseScore {
    private String courseCode;
    private int score;

    public CourseScore(String courseCode, int score) {
        this.courseCode = courseCode;
        this.score = score;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public int getScore() {
        return score;
    }
}
