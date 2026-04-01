package com.ecommerceApp.ecommerceApp.Repository.UserManagement;

import com.ecommerceApp.ecommerceApp.Entity.UserManagement.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {}
