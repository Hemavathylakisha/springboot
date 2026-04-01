package com.ecommerceApp.ecommerceApp.Dto.UserManagement;

import com.ecommerceApp.ecommerceApp.Dto.AddressManagement.AddressDTO;
import com.ecommerceApp.ecommerceApp.Dto.OrderManagement.OrderDTO;
import lombok.Data;

import java.util.List;

@Data
public class UserResponseDTO {
    private Integer id;
    private String name;
    private String email;
    private List<AddressDTO> addresses;
    private List<OrderDTO> orders;
}
