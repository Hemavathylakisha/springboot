package com.myApplication.myApplication.Contoller;

import com.myApplication.myApplication.Dto.ProductRequestDto;
import com.myApplication.myApplication.Dto.ProductResponseDto;
import com.myApplication.myApplication.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto dto) {
       return productService.create(dto);
    }

    @GetMapping(produces = "application/json")
    public List<ProductResponseDto> getAllProducts() {
        return productService.getAllProducts();
    }
}
