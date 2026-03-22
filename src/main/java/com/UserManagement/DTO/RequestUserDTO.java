package com.UserManagement.DTO;

public class RequestUserDTO {
   
    private String userName;
    private String email;
    private String mobileNo;
    private String password;

    public RequestUserDTO() {}

    // Getters and Setters

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public String getMobileNo() { return mobileNo; }

    public void setMobileNo(String mobileNo) { this.mobileNo = mobileNo; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }
}
