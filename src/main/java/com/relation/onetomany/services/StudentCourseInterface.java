package com.relation.onetomany.services;

import java.util.List;

import com.relation.onetomany.dto.CourseResponseDTO;
import com.relation.onetomany.dto.StudentResponseDTO;

public interface StudentCourseInterface {
	
	//assign Students to courses
	CourseResponseDTO assignStudentsToCourse(int courseId, List<Integer> studentIds);
	
	//assign courses to students
	StudentResponseDTO assignCoursesToStudent(int studentId, List<Integer> courseIds);

	//remove course from student
	StudentResponseDTO removeCourseFromStudent(int studentId, int courseId);
	
	//remove student from course
	CourseResponseDTO removeStudentFromCourse(int courseId, int studentId);

}
