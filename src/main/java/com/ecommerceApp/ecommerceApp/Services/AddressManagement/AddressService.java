package com.ecommerceApp.ecommerceApp.Services.AddressManagement;

import com.ecommerceApp.ecommerceApp.Dto.AddressManagement.AddressDTO;
import com.ecommerceApp.ecommerceApp.Dto.AddressManagement.AddressRequestDTO;

public interface AddressService {

    AddressDTO createAddress(Integer userId, AddressRequestDTO dto);

    void deleteAddress(Integer addressId);
}
