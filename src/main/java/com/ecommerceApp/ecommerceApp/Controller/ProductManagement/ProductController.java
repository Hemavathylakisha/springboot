package com.ecommerceApp.ecommerceApp.Controller.ProductManagement;

import com.ecommerceApp.ecommerceApp.Dto.ProductManagement.ProductRequestDTO;
import com.ecommerceApp.ecommerceApp.Dto.ProductManagement.ProductResponseDTO;
import com.ecommerceApp.ecommerceApp.Repository.ProductManagement.ProductRepository;
import com.ecommerceApp.ecommerceApp.Services.ProductManagement.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository repo;

    //  CREATE PRODUCT
    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct(
            @RequestBody ProductRequestDTO dto) {

        ProductResponseDTO response = productService.createProduct(dto);

        return ResponseEntity.status(201).body(response);
    }

    // DELETE PRODUCT
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {

        productService.deleteProduct(id);

        return ResponseEntity.noContent().build();
    }

    //pagination
    @GetMapping("/pages")
    public ResponseEntity<Page<ProductResponseDTO>> getProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        Page<ProductResponseDTO> products =
                productService.getProductsWithPagination(page, size);

        return ResponseEntity.ok(products);
    }
}
