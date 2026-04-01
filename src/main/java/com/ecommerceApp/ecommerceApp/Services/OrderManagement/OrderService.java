package com.ecommerceApp.ecommerceApp.Services.OrderManagement;

import com.ecommerceApp.ecommerceApp.Dto.OrderManagement.OrderDTO;

public interface OrderService {
    OrderDTO createOrder(OrderDTO dto);

    void deleteOrder(Integer orderId);
}
