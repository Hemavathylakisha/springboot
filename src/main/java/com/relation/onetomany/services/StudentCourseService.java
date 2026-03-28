package com.relation.onetomany.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relation.onetomany.dto.CourseResponseDTO;
import com.relation.onetomany.dto.StudentResponseDTO;
import com.relation.onetomany.entity.Course;
import com.relation.onetomany.entity.Student;
import com.relation.onetomany.mapper.CourseMapper;
import com.relation.onetomany.mapper.StudentMapper;
import com.relation.onetomany.repository.CourseRepository;
import com.relation.onetomany.repository.StudentRepository;

@Service
public class StudentCourseService implements StudentCourseInterface{
	@Autowired
    private CourseRepository courseRepo;
	
	@Autowired
    private StudentRepository studentRepo;
	
	@Override
	public CourseResponseDTO assignStudentsToCourse(int courseId, List<Integer> studentIds) {
		Course courses=courseRepo.findById(courseId).orElseThrow(()-> new RuntimeException("Course id not exists"));
		List<Student> students=studentRepo.findAllById(studentIds);
		
		for(Student s:students) {
			 if (s.getCourse() != null) {
				 s.getCourse().add(courses);
			 }
		}
		studentRepo.saveAll(students);
		
		return CourseMapper.toDto(courses);
	}

	@Override
	public StudentResponseDTO assignCoursesToStudent(int studentId, List<Integer> courseIds) {
		 Student student = studentRepo.findById(studentId)
		            .orElseThrow(() -> new RuntimeException("Student not found"));

		 List<Course> courses = courseRepo.findAllById(courseIds);
		 
		 student.setCourse(courses);
		 
		 for (Course c : courses) {
		        if (c.getStudents() != null) {
		            c.getStudents().add(student);
		        }
		    }

		    return StudentMapper.toDto(studentRepo.save(student));	
	}
	
	public StudentResponseDTO removeCourseFromStudent(int studentId, int courseId) {

	    Student student = studentRepo.findById(studentId)
	            .orElseThrow(() -> new RuntimeException("Student not found"));

	    Course course = courseRepo.findById(courseId)
	            .orElseThrow(() -> new RuntimeException("Course not found"));

	    student.getCourse().remove(course);

	    return StudentMapper.toDto(studentRepo.save(student));
	}

	public CourseResponseDTO removeStudentFromCourse(int courseId, int studentId) {

	    Course course = courseRepo.findById(courseId)
	            .orElseThrow(() -> new RuntimeException("Course not found"));

	    Student student = studentRepo.findById(studentId)
	            .orElseThrow(() -> new RuntimeException("Student not found"));

	    student.getCourse().remove(course);

	    studentRepo.save(student);

	    return CourseMapper.toDto(course);
	}
}
