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

import com.UserManagement.DTO.LaptopRequestDTO;
import com.UserManagement.DTO.LaptopResponseDTO;
import com.UserManagement.Services.LaptopService;

@RestController
@RequestMapping("/api/laptop")
public class LaptopController {
	@Autowired
    private LaptopService service;

    // CREATE
    @PostMapping
    public LaptopResponseDTO create(@RequestBody LaptopRequestDTO dto) {
        return service.create(dto);
    }
    
    // GET BY ID
    @GetMapping("/{id}")
    public LaptopResponseDTO get(@PathVariable Long id) {
        return service.getById(id);
    }

 // GET ALL
    @GetMapping
    public List<LaptopResponseDTO> getAll() {
        return service.getAll();
    }
    
    //Update 
    @PutMapping("/{id}")
    public LaptopResponseDTO updateLaptop(@PathVariable Long id, @RequestBody LaptopRequestDTO dto) {
    	return service.updateLaptop(id, dto);
    }
    
  //DELETE 
//    @DeleteMapping("/{id}")
//    public String deleteLaptop(@PathVariable Long id) {
//    	service.deleteLaptop(id);
//    	return "Laptop Removed Successfully" + id;
//    }
}
