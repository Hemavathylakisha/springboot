package com.UserManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UserManagement.DTO.RequestUserDTO;
import com.UserManagement.DTO.ResponseUserDTO;
import com.UserManagement.Services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
    private UserService service;
	
	// CREATE USER
    @PostMapping
    public ResponseUserDTO createUser(@RequestBody RequestUserDTO dto) {
        return service.createUser(dto);
    }

    // GET ALL USERS
    @GetMapping
    public List<ResponseUserDTO> getAllUsers() {
        return service.getAllUsers();
    }

    // GET USER BY ID
    @GetMapping("/{id}")
    public ResponseUserDTO getUser(@PathVariable Long id) {
        return service.getUserById(id);
    }
}
