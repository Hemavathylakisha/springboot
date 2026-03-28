package com.relation.onetomany.dto;

import java.util.List;

import com.relation.onetomany.entity.Student;

public class CourseResponseDTO {
	private int id;
    private String name;
    
	public CourseResponseDTO(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public CourseResponseDTO() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
