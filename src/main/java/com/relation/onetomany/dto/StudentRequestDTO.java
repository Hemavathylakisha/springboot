package com.relation.onetomany.dto;

import java.util.List;

public class StudentRequestDTO {
	private String name;
	private String city;
	 private List<Integer> courseIds; // only IDs
	 
	 public StudentRequestDTO() {
		super();
	 }

	 public StudentRequestDTO(String name, String city, List<Integer> courseIds) {
		super();
		this.name = name;
		this.city = city;
		this.courseIds = courseIds;
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

	 public List<Integer> getCourseIds() {
		 return courseIds;
	 }

	 public void setCourseIds(List<Integer> courseIds) {
		 this.courseIds = courseIds;
	 }
	
}
