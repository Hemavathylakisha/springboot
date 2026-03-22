package com.UserManagement.Mapper;

import java.time.LocalDateTime;

import com.UserManagement.DTO.RequestUserDTO;
import com.UserManagement.DTO.ResponseUserDTO;
import com.UserManagement.Model.User;

public class UserMapper {
	//Entity -> Dto
	public static ResponseUserDTO toDto(User user) {
		ResponseUserDTO dto=new ResponseUserDTO();
		dto.setUserName(user.getUserName());
		dto.setEmail(user.getEmail());
		dto.setMobileNo(user.getMobileNo());
		
		return dto;
	}
	// DTO → Entity
    public static User toEntity(RequestUserDTO dto) {
        User user = new User();
        user.setUserName(dto.getUserName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setMobileNo(dto.getMobileNo());

        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        return user;
    }
}
