package com.UserManagement.Mapper;

import com.UserManagement.DTO.StudentRequestDTO;
import com.UserManagement.DTO.StudentResponseDTO;
import com.UserManagement.Model.Students;

public class StudentMapper {
	// DTO → Entity
    public static Students toEntity(StudentRequestDTO dto) {
    	 Students student = new Students();
         student.setRollno(dto.getRollno());
         student.setName(dto.getName());
         student.setDeptName(dto.getDeptName());
         student.setCity(dto.getCity());
         
         return student;
    }
 // Entity → DTO
    public static StudentResponseDTO toDTO(Students student) {

        StudentResponseDTO dto = new StudentResponseDTO();
        dto.setRollno(student.getRollno());
        dto.setName(student.getName());
        dto.setDeptName(student.getDeptName());
        dto.setCity(student.getCity());

        return dto;
    }
}
