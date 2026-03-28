package com.relation.onetomany.services;

import java.util.List;

import com.relation.onetomany.dto.CourseRequestDTO;
import com.relation.onetomany.dto.CourseResponseDTO;

public interface CourseInterface {
	// CREATE
   CourseResponseDTO create(CourseRequestDTO dto);
   
   // GET ALL
   List<CourseResponseDTO> getAll();
   
   // GET BY ID
  CourseResponseDTO getById(int id);
  
  //UPDATE
  CourseResponseDTO update(int id, CourseRequestDTO dto);
  
  //delete
  void delete(int id);
}
