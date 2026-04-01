package com.ecommerceApp.ecommerceApp.Entity.UserManagement;

import com.ecommerceApp.ecommerceApp.Entity.AddressManagement.Address;
import com.ecommerceApp.ecommerceApp.Entity.OrderManagement.Orders;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Address> addresses;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Orders> orders;

}