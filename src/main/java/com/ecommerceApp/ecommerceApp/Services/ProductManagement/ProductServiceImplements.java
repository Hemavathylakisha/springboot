package com.ecommerceApp.ecommerceApp.Services.ProductManagement;

import com.ecommerceApp.ecommerceApp.Dto.ProductManagement.ProductRequestDTO;
import com.ecommerceApp.ecommerceApp.Dto.ProductManagement.ProductResponseDTO;
import com.ecommerceApp.ecommerceApp.Entity.ProductManagement.Product;
import com.ecommerceApp.ecommerceApp.Mapper.ProductManagement.ProductMapper;
import com.ecommerceApp.ecommerceApp.Repository.ProductManagement.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImplements implements ProductService {

    @Autowired
    private ProductRepository productRepo;

    //  Create Product
    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO dto) {
        Product product = ProductMapper.toEntity(dto);

        Product saved = productRepo.save(product);

        return ProductMapper.toDTO(saved);
    }

    //  Delete Product
    @Override
    public void deleteProduct(Integer id) {

        Product product = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found " + id));

        productRepo.delete(product);
    }

    //pagination
    @Override
    public Page<ProductResponseDTO> getProductsWithPagination(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        Page<Product> productPage = productRepo.findAll(pageable);

        return productPage.map(ProductMapper::toDTO);
    }
}