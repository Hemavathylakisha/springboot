package com.relation.onetomany.Controller;

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

import com.relation.onetomany.dto.StudentRequestDTO;
import com.relation.onetomany.dto.StudentResponseDTO;
import com.relation.onetomany.services.StudentService;

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

    // GET ALL
    @GetMapping("/all")
    public List<StudentResponseDTO> getAll() {
        return service.getAll();
    }

    //GET BY ID
    @GetMapping("/{id}")
    public StudentResponseDTO get(@PathVariable int id) {
        return service.getById(id);
    }

    //UPDATE
    @PutMapping("/{id}")
    public StudentResponseDTO update(@PathVariable int id,
                                     @RequestBody StudentRequestDTO dto) {
        return service.update(id, dto);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        service.delete(id);
        return "Student deleted successfully";
    }
}
