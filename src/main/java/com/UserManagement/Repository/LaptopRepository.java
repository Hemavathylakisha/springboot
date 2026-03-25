package com.UserManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UserManagement.Model.Laptop;

public interface LaptopRepository extends JpaRepository<Laptop, Long> {
}
