package com.ecommerceApp.ecommerceApp.Services.UserManagement;

import com.ecommerceApp.ecommerceApp.Dto.UserManagement.UserRequestDTO;
import com.ecommerceApp.ecommerceApp.Dto.UserManagement.UserResponseDTO;
import com.ecommerceApp.ecommerceApp.Entity.UserManagement.User;

public interface UserService {
    // To get full detail
    UserResponseDTO getUserFullDetails(Integer userId);

    //create user
    UserResponseDTO createUser(UserRequestDTO dto);

    //delete user
    void deleteUser(Integer userId);
}
