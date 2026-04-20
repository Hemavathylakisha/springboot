package com.myApplication.myApplication.Mapper;

import com.myApplication.myApplication.Dto.ProductRequestDto;
import com.myApplication.myApplication.Dto.ProductResponseDto;
import com.myApplication.myApplication.Entity.Product;


public class ProductMapper {
    public static Product toEntity(ProductRequestDto dto){
        return Product.builder()
                .name(dto.getName())
                .category(dto.getCategory())
                .cost(dto.getCost())
                .rating(dto.getRating())
                .image(dto.getImage())
                .build();
    }
    public static ProductResponseDto toDto(Product product) {
        return ProductResponseDto.builder()
                .id(product.getId())
                .name(product.getName())
                .category(product.getCategory())
                .cost(product.getCost())
                .rating(product.getRating())
                .image(product.getImage())
                .build();
    }
}
