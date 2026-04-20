package com.myApplication.myApplication.Repository;

import com.myApplication.myApplication.Dto.UserResponseDto;
import com.myApplication.myApplication.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String username);
}
