package com.example.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.example.domain.CourseScore;
import com.example.domain.Degree;
import com.example.domain.Department;
import com.example.domain.ElectiveEnrolledDto;
import com.example.domain.ElectiveEnrolledStudentDTO;
import com.example.domain.EnrolledCourse;
import com.example.domain.Enrollment;
import com.example.domain.Student;

public class StreamsExamplesNew {
	
	
	public static void main(String[] args) {
		
		// 1
		Department dep1 = new Department("D1");
		Department dep2 = new Department("D2");
		Department dep3 = new Department("D3");
		Department dep4 = new Department("D4");
		
		List<Department> departments = Arrays.asList(dep1, dep2, dep3, dep4);
		
		Degree degree = new Degree(departments);
		String deptToFind = "D2";
		
		Department selectedDepartment = degree.getDepartments().stream()
		.filter(p -> p.getDeptId().equals(deptToFind))
		.findFirst()
		.orElse(null);
		
		System.out.println("selectedDepartment =" + selectedDepartment.getDeptId());
		
		
		// 2
		CourseScore cs1 = new CourseScore("CS101", 80);
		CourseScore cs2 = new CourseScore("CS102", 70);
		CourseScore cs3 = new CourseScore("CS103", 45);
		
		List<CourseScore> courseScores  = Arrays.asList(cs1, cs2, cs3);
		
		Student student = new Student("123", courseScores);
		String courseCode = "CS103";

		List<Student> backlogStudentDetails = Arrays.asList(student);
		
		Student enrolledStudent = new Student("123", courseScores);
		
		backlogStudentDetails.stream()
		.filter(stu -> stu.getUsn().equals(enrolledStudent.getUsn()))
		.findAny()
		.ifPresent(data -> {
			data.getCourseScores().stream()
			.filter(backlogCourse -> backlogCourse.getCourseCode()
					.equals(courseCode))
			.findAny()
			.ifPresent(backlogSubject -> {
				enrolledStudent.setBacklogCourse(true);
			});
		});
		
		System.out.println(enrolledStudent.hasBacklogCourse());
		
		
		// 3
		List<Enrollment> existingCourseEnrollments = new ArrayList<>();
		
		List<EnrolledCourse> enrolledCourses1 = Arrays.asList(new EnrolledCourse("CS101"), new EnrolledCourse("CS102"));
		Enrollment enrollment1 = new Enrollment(enrolledCourses1);
		
		List<EnrolledCourse> enrolledCourses2 = Arrays.asList(new EnrolledCourse("CS103"), new EnrolledCourse("CS104"));
		Enrollment enrollment2 = new Enrollment(enrolledCourses2);
		
		existingCourseEnrollments.addAll(Arrays.asList(enrollment1, enrollment2));
		
		
		Set<String> codes = existingCourseEnrollments.stream()
		.flatMap(enroll -> enroll.getEnrolledCourses().stream())
		.map(EnrolledCourse::getCourseCode)
		.collect(Collectors.toSet());
		
		System.out.println(codes);
		
		
		// 4
		ElectiveEnrolledStudentDTO student1 = new ElectiveEnrolledStudentDTO("S101");
		ElectiveEnrolledStudentDTO student2 = new ElectiveEnrolledStudentDTO("S102");
		
		List<ElectiveEnrolledStudentDTO> studentList1 = Arrays.asList(student1, student2);
		
		ElectiveEnrolledStudentDTO student3 = new ElectiveEnrolledStudentDTO("S103");
		ElectiveEnrolledStudentDTO student4 = new ElectiveEnrolledStudentDTO("S104");
		
		List<ElectiveEnrolledStudentDTO> studentList2 = Arrays.asList(student3, student4);
		
		ElectiveEnrolledDto electiveDto1 = new ElectiveEnrolledDto(studentList1);
		electiveDto1.setCourseCode("C101");
		ElectiveEnrolledDto electiveDto2 = new ElectiveEnrolledDto(studentList2);
		electiveDto2.setCourseCode("C102");
		List<ElectiveEnrolledDto> enrolledElectiveDtos = Arrays.asList(electiveDto1, electiveDto2);
		
		Student s1 = new Student(null, null);
		s1.setId("S101");
		
		Set<String> enrolledCourses = enrolledElectiveDtos.stream()
		.filter(c -> c.getEnrolledStudents().stream()
				.anyMatch(s -> s.getStudentId().equals(s1.getId())))
		.map(ElectiveEnrolledDto::getCourseCode)
		.collect(Collectors.toSet());
		
		System.out.println(enrolledCourses);
	}
}
