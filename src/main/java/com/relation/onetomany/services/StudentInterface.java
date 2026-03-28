package com.relation.onetomany.services;

import java.util.List;

import com.relation.onetomany.dto.StudentRequestDTO;
import com.relation.onetomany.dto.StudentResponseDTO;

public interface StudentInterface {
	//create
	StudentResponseDTO create(StudentRequestDTO dto);
	
	//getall
	List<StudentResponseDTO> getAll();
	
	//delete
	void delete(int id);
	
	//get by id
	StudentResponseDTO getById(int id);
	
	//update
	StudentResponseDTO update(int id, StudentRequestDTO dto);
}
