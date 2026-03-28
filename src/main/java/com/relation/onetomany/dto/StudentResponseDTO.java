package com.relation.onetomany.dto;

import java.util.List;

public class StudentResponseDTO {
	private int id;
	private String name;
	private String city;
	private List<String> courses;
	
	public StudentResponseDTO(int id, String name, String city, List<String> courses) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.courses = courses;
	}
	
	public StudentResponseDTO() {
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public List<String> getCourse() {
		return courses;
	}
	public void setCourse(List<String> courses) {
		this.courses = courses;
	}
	
}
