package com.ecommerceApp.ecommerceApp.Mapper.AddressManagement;

import com.ecommerceApp.ecommerceApp.Dto.AddressManagement.AddressDTO;
import com.ecommerceApp.ecommerceApp.Dto.AddressManagement.AddressRequestDTO;
import com.ecommerceApp.ecommerceApp.Entity.AddressManagement.Address;

public class AddressMapper {

    // DTO → Entity (Create)
    public static Address toEntity(AddressRequestDTO dto) {
        if (dto == null) return null;

        Address address = new Address();

        // not set ID for create
        address.setCity(dto.getCity());
        address.setState(dto.getState());

        return address;
    }
    public static AddressDTO toDTO(Address address) {
        AddressDTO dto = new AddressDTO();
        dto.setId(address.getId());
        dto.setCity(address.getCity());
        dto.setState(address.getState());
        return dto;
    }
}
