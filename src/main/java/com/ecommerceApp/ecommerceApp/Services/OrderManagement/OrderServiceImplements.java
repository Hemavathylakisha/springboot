package com.ecommerceApp.ecommerceApp.Services.OrderManagement;

import com.ecommerceApp.ecommerceApp.Dto.OrderManagement.OrderDTO;
import com.ecommerceApp.ecommerceApp.Entity.OrderManagement.Orders;
import com.ecommerceApp.ecommerceApp.Entity.ProductManagement.Product;
import com.ecommerceApp.ecommerceApp.Entity.UserManagement.User;
import com.ecommerceApp.ecommerceApp.Mapper.OrderManagement.OrderMapper;
import com.ecommerceApp.ecommerceApp.Repository.OrderManagement.OrderRepository;
import com.ecommerceApp.ecommerceApp.Repository.ProductManagement.ProductRepository;
import com.ecommerceApp.ecommerceApp.Repository.UserManagement.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImplements implements OrderService{
    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private UserRepository userRepo;

    // Create Order
    @Override
    public OrderDTO createOrder(OrderDTO dto) {

        // Fetch User
        User user = userRepo.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Fetch Products
        List<Product> products = productRepo.findAllById(dto.getProductIds());

        Orders order = OrderMapper.toEntity(dto);

        // Map DTO → Entity
        Orders orders = new Orders();
        orders.setStatus(dto.getStatus());
        orders.setUser(user);
        orders.setProducts(products);

        Orders saved = orderRepo.save(orders);

        return OrderMapper.toDTO(saved);
    }

    // Delete Order
    @Override
    public void deleteOrder(Integer orderId) {

        Orders order = orderRepo.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found " + orderId));

        orderRepo.delete(order);
    }
}
