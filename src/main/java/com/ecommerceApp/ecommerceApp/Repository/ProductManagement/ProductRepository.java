package com.ecommerceApp.ecommerceApp.Repository.ProductManagement;

import com.ecommerceApp.ecommerceApp.Entity.ProductManagement.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {}
