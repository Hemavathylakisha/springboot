package com.UserManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UserManagement.Model.Students;

public interface StudentRepository extends JpaRepository<Students, Long> {

}
