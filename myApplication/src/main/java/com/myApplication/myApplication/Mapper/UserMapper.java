package com.myApplication.myApplication.Mapper;

import com.myApplication.myApplication.Dto.UserRequestDto;
import com.myApplication.myApplication.Dto.UserResponseDto;
import com.myApplication.myApplication.Entity.User;

public class UserMapper {
    public static User toEntity(UserRequestDto req){
        User user=new User();
        user.setUsername(req.getUsername());
        user.setPassword(req.getPassword());
        user.setRole(req.getRole());

        return user;
    }
    public static UserResponseDto toDto(User user){
        UserResponseDto dto=new UserResponseDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setPassword(user.getPassword());
        dto.setRole(user.getRole());
        return dto;
    }
}
