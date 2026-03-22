package com.UserManagement.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UserManagement.DTO.RequestUserDTO;
import com.UserManagement.DTO.ResponseUserDTO;
import com.UserManagement.Mapper.UserMapper;
import com.UserManagement.Model.User;
import com.UserManagement.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	//create user
	public ResponseUserDTO createUser(RequestUserDTO dto) {
		User user=UserMapper.toEntity(dto);
		User saveduser=repository.save(user);
		return UserMapper.toDto(saveduser);
	}
	
	 // GET ALL USERS
    public List<ResponseUserDTO> getAllUsers() {
    	return repository.findAll().stream()
    			.map(UserMapper::toDto).toList();
    }
    // GET USER BY ID
    public ResponseUserDTO getUserById(Long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return UserMapper.toDto(user);
    }
}
