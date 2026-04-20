package com.myApplication.myApplication.Service;

import com.myApplication.myApplication.Dto.UserRequestDto;
import com.myApplication.myApplication.Dto.UserResponseDto;
import com.myApplication.myApplication.Entity.User;

public interface UserServiceInterface {
    UserResponseDto register(UserRequestDto req);
}
