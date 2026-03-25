package com.UserManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UserManagement.DTO.StudentRequestDTO;
import com.UserManagement.DTO.StudentResponseDTO;
import com.UserManagement.Services.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService service;

    // CREATE
    @PostMapping
    public StudentResponseDTO create(@RequestBody StudentRequestDTO dto) {
        return service.create(dto);
    }
    
    // GET BY ID
    @GetMapping("/{id}")
    public StudentResponseDTO get(@PathVariable Long id) {
        return service.getById(id);
    }

 // GET ALL Students
    @GetMapping
    public List<StudentResponseDTO> getAllUsers() {
        return service.getAllStudents();
    }
    
    //Update 
    @PutMapping("/{id}")
    public StudentResponseDTO updateStudent(@PathVariable Long id, @RequestBody StudentRequestDTO dto) {
    	return service.updateStudent(id, dto);
    }
    
  //DELETE Student
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
    	service.deleteStudent(id);
    	return "Student Removed Successfully" + id;
    }
}
