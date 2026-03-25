package com.UserManagement.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UserManagement.DTO.LaptopRequestDTO;
import com.UserManagement.DTO.LaptopResponseDTO;
import com.UserManagement.DTO.StudentRequestDTO;
import com.UserManagement.DTO.StudentResponseDTO;
import com.UserManagement.Mapper.LaptopMapper;
import com.UserManagement.Mapper.StudentMapper;
import com.UserManagement.Model.Laptop;
import com.UserManagement.Model.Students;
import com.UserManagement.Repository.LaptopRepository;

@Service
public class LaptopService {
	@Autowired
	private LaptopRepository repository;
	
	// CREATE
    public LaptopResponseDTO create(LaptopRequestDTO dto) {
        Laptop laptop = LaptopMapper.toEntity(dto);
        Laptop saved = repository.save(laptop);
        return LaptopMapper.toDTO(saved);
    }

    // GET BY ID
    public LaptopResponseDTO getById(Long id) {
    	Laptop laptop = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Laptop not found"));

        return LaptopMapper.toDTO(laptop);
    }
    
 // GET ALL 
    public List<LaptopResponseDTO> getAll() {
    	return repository.findAll().stream()
    			.map(LaptopMapper::toDTO).toList();
    }
    
  //GET UPDATE BY ID
    public LaptopResponseDTO updateLaptop(Long id, LaptopRequestDTO dto) {
    	Laptop laptop=repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Laptop not found with the id" + id));
    	laptop.setLapName(dto.getLapName());
    	laptop.setProcessor(dto.getProcessor());
    	
    	Laptop updatedlaptop=repository.save(laptop);
    return LaptopMapper.toDTO(updatedlaptop);
    }
    
  //Delete Laptop
//    public void deleteLaptop(Long id) {
//    	if(!repository.existsById(id)) {
//    		throw new RuntimeException("Laptop not found with this id"+ id);
//    	}
//    	repository.deleteById(id);
//    }
}
