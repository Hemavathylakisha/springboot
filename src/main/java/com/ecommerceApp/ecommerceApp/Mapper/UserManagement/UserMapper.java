package com.ecommerceApp.ecommerceApp.Mapper.UserManagement;

import com.ecommerceApp.ecommerceApp.Dto.UserManagement.UserRequestDTO;
import com.ecommerceApp.ecommerceApp.Dto.UserManagement.UserResponseDTO;
import com.ecommerceApp.ecommerceApp.Entity.AddressManagement.Address;
import com.ecommerceApp.ecommerceApp.Entity.OrderManagement.Orders;
import com.ecommerceApp.ecommerceApp.Entity.ProductManagement.Product;
import com.ecommerceApp.ecommerceApp.Entity.UserManagement.User;
import com.ecommerceApp.ecommerceApp.Mapper.AddressManagement.AddressMapper;
import com.ecommerceApp.ecommerceApp.Mapper.OrderManagement.OrderMapper;

import java.util.List;

public class UserMapper {

    // RequestDTO → Entity
    public static User toEntity(UserRequestDTO dto, List<Product> products) {

        User user = new User();

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());

        // Address Mapping
        if (dto.getAddresses() != null) {
            List<Address> addresses = dto.getAddresses()
                    .stream()
                    .map(AddressMapper::toEntity) // correct method
                    .toList();

            // Set parent (VERY IMPORTANT)
            addresses.forEach(address -> address.setUser(user));

            user.setAddresses(addresses);
        }

        // Order Mapping
        Orders order = new Orders();
        order.setStatus(dto.getOrderStatus());
        order.setUser(user);
        order.setProducts(products);

        user.setOrders(List.of(order));

        return user;
    }

    // Entity → ResponseDTO
    public static UserResponseDTO toDTO(User user) {

        UserResponseDTO dto = new UserResponseDTO();

        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());

        if (user.getAddresses() != null) {
            dto.setAddresses(
                    user.getAddresses()
                            .stream()
                            .map(AddressMapper::toDTO)
                            .toList()
            );
        }

        if (user.getOrders() != null) {
            dto.setOrders(
                    user.getOrders()
                            .stream()
                            .map(OrderMapper::toDTO)
                            .toList()
            );
        }

        return dto;
    }
}