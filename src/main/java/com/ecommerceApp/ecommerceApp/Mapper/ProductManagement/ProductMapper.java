package com.ecommerceApp.ecommerceApp.Mapper.ProductManagement;

import com.ecommerceApp.ecommerceApp.Dto.ProductManagement.ProductRequestDTO;
import com.ecommerceApp.ecommerceApp.Dto.ProductManagement.ProductResponseDTO;
import com.ecommerceApp.ecommerceApp.Entity.ProductManagement.Product;

public class ProductMapper {
    public static Product toEntity(ProductRequestDTO dto) {
        Product product = new Product();

        product.setId(dto.getId());
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());

        return product;
    }
    public static ProductResponseDTO toDTO(Product product) {
        ProductResponseDTO dto = new ProductResponseDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        return dto;
    }
}
