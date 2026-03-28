package com.relation.onetomany.mapper;

import java.util.stream.Collectors;

import com.relation.onetomany.dto.CourseRequestDTO;
import com.relation.onetomany.dto.CourseResponseDTO;
import com.relation.onetomany.entity.Course;

public class CourseMapper {
	public static Course toEntity(CourseRequestDTO dto) {
		Course courses=new Course();
		courses.setName(dto.getName());
		
		return courses;
	}
	public static CourseResponseDTO toDto(Course courses) {
		CourseResponseDTO dto=new CourseResponseDTO();
		dto.setId(courses.getId());
		dto.setName(courses.getName());
	
		return dto;
	}
}
