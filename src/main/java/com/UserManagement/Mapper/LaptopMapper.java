package com.UserManagement.Mapper;

import com.UserManagement.DTO.LaptopRequestDTO;
import com.UserManagement.DTO.LaptopResponseDTO;
import com.UserManagement.Model.Laptop;

public class LaptopMapper {
	// DTO → Entity
    public static Laptop toEntity(LaptopRequestDTO dto) {
    	Laptop lap = new Laptop();
    	lap.setLapName(dto.getLapName());
    	lap.setProcessor(dto.getProcessor());

         return lap;
    }
    // Entity → DTO
    public static LaptopResponseDTO toDTO(Laptop laptop) {

    	LaptopResponseDTO dto = new LaptopResponseDTO();
        dto.setLapName(laptop.getLapName());
        dto.setProcessor(laptop.getProcessor());
        
        return dto;
    }
}
