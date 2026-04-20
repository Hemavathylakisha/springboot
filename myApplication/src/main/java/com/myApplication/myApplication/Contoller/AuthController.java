package com.myApplication.myApplication.Contoller;

import com.myApplication.myApplication.Dto.UserRequestDto;
import com.myApplication.myApplication.Dto.UserResponseDto;
import com.myApplication.myApplication.JwtUtil.JwtUtil;
import com.myApplication.myApplication.Service.UserServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    private final UserServiceInterface userservice;
    private AuthenticationManager authManager;

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody UserRequestDto req) {
        return userservice.register(req);
    }

    @GetMapping("/")
    public String profile() {
        return "Profile screen - after login";
    }

    @PostMapping("/signIn")
    public String login(@RequestParam String username, @RequestParam String password) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        if (authentication.isAuthenticated()) {
            String role = authentication.getAuthorities()
                    .stream()
                    .map((x) -> x.getAuthority())
                    .findFirst()
                    .get()
                    .toUpperCase();
            String token = JwtUtil.generateToken(username, role);
            return token;
        } else {
             return "invalid username and password";
        }
    }

}