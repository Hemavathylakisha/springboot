package com.myApplication.myApplication.Service;

import com.myApplication.myApplication.Dto.UserRequestDto;
import com.myApplication.myApplication.Dto.UserResponseDto;
import com.myApplication.myApplication.Entity.User;
import com.myApplication.myApplication.Mapper.UserMapper;
import com.myApplication.myApplication.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserServiceInterface{

    private UserRepository userRepo;
    private PasswordEncoder passwordEncoder;

    @Override
    public UserResponseDto register(UserRequestDto req) {
       User user= UserMapper.toEntity(req);
       user.setPassword(passwordEncoder.encode(req.getPassword()));
       User savedUser = userRepo.save(user);
       return UserMapper.toDto(savedUser);
    }

}
