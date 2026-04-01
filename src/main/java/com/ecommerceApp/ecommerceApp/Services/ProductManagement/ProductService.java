package com.ecommerceApp.ecommerceApp.Services.ProductManagement;

import com.ecommerceApp.ecommerceApp.Dto.ProductManagement.ProductRequestDTO;
import com.ecommerceApp.ecommerceApp.Dto.ProductManagement.ProductResponseDTO;
import org.springframework.data.domain.Page;

public interface ProductService {

    ProductResponseDTO createProduct(ProductRequestDTO dto);

    void deleteProduct(Integer id);

    //pagination
    Page<ProductResponseDTO> getProductsWithPagination(int page, int size);
}
