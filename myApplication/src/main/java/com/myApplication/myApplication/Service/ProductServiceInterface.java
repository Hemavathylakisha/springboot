package com.myApplication.myApplication.Service;

import com.myApplication.myApplication.Dto.ProductRequestDto;
import com.myApplication.myApplication.Dto.ProductResponseDto;

import java.util.List;

public interface ProductServiceInterface {
    ProductResponseDto create(ProductRequestDto dto);
    List<ProductResponseDto> getAllProducts();
}
