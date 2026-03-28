package com.relation.onetomany.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.relation.onetomany.dto.StudentRequestDTO;
import com.relation.onetomany.dto.StudentResponseDTO;
import com.relation.onetomany.entity.Course;
import com.relation.onetomany.entity.Student;

public class StudentMapper {
	public static Student toEntity(StudentRequestDTO dto, List<Course> courses) {
		Student students=new Student();
		students.setCity(dto.getCity());
		students.setName(dto.getName());
		students.setCourse(courses);
		
		 for (Course c : courses) {
	            if (c.getStudents() != null) {
	                c.getStudents().add(students);
	            }
	        }
		return students;
	}
	
	public static StudentResponseDTO toDto(Student students) {
		StudentResponseDTO dto=new StudentResponseDTO();
		dto.setId(students.getId());
		dto.setName(students.getName());
		dto.setCity(students.getCity());
		
		if (students.getCourse() != null) {
			dto.setCourse(
					students.getCourse().stream()
					.map(Course::getName)
					.collect(Collectors.toList())
					);
		}
		return dto;
	}
}
