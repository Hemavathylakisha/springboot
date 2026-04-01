package com.ecommerceApp.ecommerceApp.Entity.AddressManagement;

import com.ecommerceApp.ecommerceApp.Entity.UserManagement.User;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String city;
    private String state;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}