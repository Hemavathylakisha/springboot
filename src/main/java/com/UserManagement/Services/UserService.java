package com.UserManagement.Services;

import java.time.LocalDateTime;
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
    
    //GET UPDATE BY ID
    public ResponseUserDTO updateUser(Long id, RequestUserDTO dto) {
    	User user=repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with the id" + id));
    user.setUserName(dto.getUserName());
    user.setMobileNo(dto.getMobileNo());
    user.setEmail(dto.getEmail());
    user.setPassword(dto.getPassword());
    user.setUpdatedAt(LocalDateTime.now());
    User updateduser=repository.save(user);
    return UserMapper.toDto(updateduser);
    }
    
    //Delete user
    public void deleteUser(Long id) {
    	if(!repository.existsById(id)) {
    		throw new RuntimeException("User not found with this id"+ id);
    	}
    	repository.deleteById(id);
    }
    
}
