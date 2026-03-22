package com.UserManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UserManagement.Model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
