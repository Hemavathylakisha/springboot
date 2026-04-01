package com.ecommerceApp.ecommerceApp.Dto.UserManagement;

import com.ecommerceApp.ecommerceApp.Dto.AddressManagement.AddressRequestDTO;
import lombok.Data;

import java.util.List;

@Data
public class UserRequestDTO {
    private String name;
    private String email;

    // Addresses to create
    private List<AddressRequestDTO> addresses;

    // Instead of full product objects → use IDs
    private List<Integer> productIds;

    private String orderStatus;
}
