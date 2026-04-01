package com.ecommerceApp.ecommerceApp.Controller.UserManagement;

import com.ecommerceApp.ecommerceApp.Dto.UserManagement.UserRequestDTO;
import com.ecommerceApp.ecommerceApp.Dto.UserManagement.UserResponseDTO;
import com.ecommerceApp.ecommerceApp.Services.UserManagement.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/userorder")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}/show")
    public ResponseEntity<UserResponseDTO> getUserDetails(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.getUserFullDetails(id));
    }
    // CREATE USER
    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO dto) {

        UserResponseDTO response = userService.createUser(dto);

        return ResponseEntity.ok(response);
    }

    // DELETE USER
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {

        userService.deleteUser(id);

        return ResponseEntity.ok("User deleted successfully");
    }
}
