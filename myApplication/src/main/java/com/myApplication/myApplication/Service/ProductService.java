package com.myApplication.myApplication.Service;

import com.myApplication.myApplication.Dto.ProductRequestDto;
import com.myApplication.myApplication.Dto.ProductResponseDto;
import com.myApplication.myApplication.Entity.Product;
import com.myApplication.myApplication.Mapper.ProductMapper;
import com.myApplication.myApplication.Repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService implements ProductServiceInterface{
    private final ProductRepository productRepository;

    @Override
    public ProductResponseDto create(ProductRequestDto dto) {
        Product product=ProductMapper.toEntity(dto);
        Product saveproduct=productRepository.save(product);
        return ProductMapper.toDto(saveproduct);
    }

    @Override
    public List<ProductResponseDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        System.out.println("Products: " + products);
        return products.stream()
                .map(ProductMapper::toDto)
                .toList();
    }
}
