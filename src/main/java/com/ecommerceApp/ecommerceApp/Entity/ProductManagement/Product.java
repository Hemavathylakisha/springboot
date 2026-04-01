package com.ecommerceApp.ecommerceApp.Entity.ProductManagement;

import com.ecommerceApp.ecommerceApp.Entity.OrderManagement.Orders;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private double price;

    @ManyToMany(mappedBy = "products")
    private List<Orders> orders;

}
