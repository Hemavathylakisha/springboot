package com.UserManagement.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UserManagement.DTO.StudentRequestDTO;
import com.UserManagement.DTO.StudentResponseDTO;
import com.UserManagement.Mapper.StudentMapper;
import com.UserManagement.Mapper.UserMapper;
import com.UserManagement.Model.Students;
import com.UserManagement.Repository.StudentRepository;

@Service
public class StudentService {
	 @Autowired
	    private StudentRepository repository;
	 
	// CREATE
	    public StudentResponseDTO create(StudentRequestDTO dto) {
	        Students student = StudentMapper.toEntity(dto);
	        Students saved = repository.save(student);
	        return StudentMapper.toDTO(saved);
	    }

	    // GET BY ID
	    public StudentResponseDTO getById(Long id) {
	        Students student = repository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Student not found"));

	        return StudentMapper.toDTO(student);
	    }
	    
	 // GET ALL USERS
	    public List<StudentResponseDTO> getAllStudents() {
	    	return repository.findAll().stream()
	    			.map(StudentMapper::toDTO).toList();
	    }
	    
	  //GET UPDATE BY ID
	    public StudentResponseDTO updateStudent(Long id, StudentRequestDTO dto) {
	    	Students student=repository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Student not found with the id" + id));
	    	student.setRollno(dto.getRollno());
	    	student.setName(dto.getName());
	    	student.setDeptName(dto.getDeptName());
	    	student.setCity(dto.getCity());
	    Students updatedstudent=repository.save(student);
	    return StudentMapper.toDTO(updatedstudent);
	    }
	    
	  //Delete Student
	    public void deleteStudent(Long id) {
	    	if(!repository.existsById(id)) {
	    		throw new RuntimeException("Student not found with this id"+ id);
	    	}
	    	repository.deleteById(id);
	    }
}
