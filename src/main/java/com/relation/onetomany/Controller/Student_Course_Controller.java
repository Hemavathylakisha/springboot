package com.relation.onetomany.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.relation.onetomany.dto.CourseResponseDTO;
import com.relation.onetomany.dto.StudentResponseDTO;
import com.relation.onetomany.services.StudentCourseService;

@RestController
@RequestMapping("/api")
public class Student_Course_Controller {

	  @Autowired
	    private StudentCourseService service;
	  
	    // Assign courses to student
	    @PutMapping("/students/{studentId}/courses")
	    public StudentResponseDTO assignCoursesToStudent(
	            @PathVariable int studentId,
	            @RequestBody List<Integer> courseIds) {

	        return service.assignCoursesToStudent(studentId, courseIds);
	    }

	    // Remove course from student
	    @DeleteMapping("/students/{studentId}/courses/{courseId}")
	    public StudentResponseDTO removeCourseFromStudent(
	            @PathVariable int studentId,
	            @PathVariable int courseId) {

	        return service.removeCourseFromStudent(studentId, courseId);
	    }
	    
	 // Assign students to course
	    @PutMapping("/courses/{courseId}/students")
	    public CourseResponseDTO assignStudentsToCourse(
	            @PathVariable int courseId,
	            @RequestBody List<Integer> studentIds) {

	        return service.assignStudentsToCourse(courseId, studentIds);
	    }

	    // Remove student from course
	    @DeleteMapping("/courses/{courseId}/students/{studentId}")
	    public CourseResponseDTO removeStudentFromCourse(
	            @PathVariable int courseId,
	            @PathVariable int studentId) {

	        return service.removeStudentFromCourse(courseId, studentId);
	    }
}
