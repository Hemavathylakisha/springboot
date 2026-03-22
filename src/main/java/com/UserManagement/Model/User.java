package com.UserManagement.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false, unique = true)
    private String email;

    private String mobileNo;

    @Column(nullable = false)
    private String password;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public User() {}

    // Getters and Setters

    public Long getId() { return id; }

    public String getUserName() { return userName; }

    public String getEmail() { return email; }

    public String getMobileNo() { return mobileNo; }

    public String getPassword() { return password; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }

    public void setId(Long id) { this.id = id; }

    public void setUserName(String userName) { this.userName = userName; }

    public void setEmail(String email) { this.email = email; }

    public void setMobileNo(String mobileNo) { this.mobileNo = mobileNo; }

    public void setPassword(String password) { this.password = password; }

    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}