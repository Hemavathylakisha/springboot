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

import com.relation.onetomany.dto.CourseRequestDTO;
import com.relation.onetomany.dto.CourseResponseDTO;
import com.relation.onetomany.services.CourseService;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
	 @Autowired
	    private CourseService service;

	    // CREATE
	    @PostMapping
	    public CourseResponseDTO create(@RequestBody CourseRequestDTO dto) {
	        return service.create(dto);
	    }

	    // GET ALL
	    @GetMapping("/all")
	    public List<CourseResponseDTO> getAll() {
	        return service.getAll();
	    }

	    // GET BY ID
	    @GetMapping("/{id}")
	    public CourseResponseDTO get(@PathVariable int id) {
	        return service.getById(id);
	    }

	    // UPDATE
	    @PutMapping("/{id}")
	    public CourseResponseDTO update(@PathVariable int id,
	                                    @RequestBody CourseRequestDTO dto) {
	        return service.update(id, dto);
	    }

	    // DELETE
	    @DeleteMapping("/{id}")
	    public String delete(@PathVariable int id) {
	        service.delete(id);
	        return "Course deleted successfully";
	    }
}
