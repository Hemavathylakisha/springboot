package com.ecommerceApp.ecommerceApp.Controller.OrderManagement;

import com.ecommerceApp.ecommerceApp.Dto.OrderManagement.OrderDTO;
import com.ecommerceApp.ecommerceApp.Services.OrderManagement.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // CREATE ORDER
    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO dto) {

        OrderDTO response = orderService.createOrder(dto);

        return ResponseEntity.status(201).body(response);
    }

    // DELETE ORDER
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Integer id) {

        orderService.deleteOrder(id);

        return ResponseEntity.noContent().build();
    }
}
