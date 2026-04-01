package com.ecommerceApp.ecommerceApp.Dto.OrderManagement;

import com.ecommerceApp.ecommerceApp.Dto.ProductManagement.ProductResponseDTO;
import lombok.Data;

import java.util.Collection;
import java.util.List;

@Data
public class OrderDTO {
    private Integer id;
    private String status;
    private List<Integer> productIds;
    private Integer userId;
    
}
