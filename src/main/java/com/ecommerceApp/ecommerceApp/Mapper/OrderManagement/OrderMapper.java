package com.ecommerceApp.ecommerceApp.Mapper.OrderManagement;

import com.ecommerceApp.ecommerceApp.Dto.OrderManagement.OrderDTO;
import com.ecommerceApp.ecommerceApp.Entity.OrderManagement.Orders;

public class OrderMapper {

    // DTO → Entity (ONLY basic fields)
    public static Orders toEntity(OrderDTO dto) {
        Orders order = new Orders();

        order.setId(dto.getId());
        order.setStatus(dto.getStatus());

        //DO NOT map products here

        return order;
    }

    // Entity → DTO
    public static OrderDTO toDTO(Orders order) {
        OrderDTO dto = new OrderDTO();

        dto.setId(order.getId());
        dto.setStatus(order.getStatus());
        dto.setUserId(order.getUser().getId());

        // Convert products → productIds
        if (order.getProducts() != null) {
            dto.setProductIds(
                    order.getProducts()
                            .stream()
                            .map(product -> product.getId())
                            .toList()
            );
        }

        return dto;
    }
}