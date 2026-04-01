package com.ecommerceApp.ecommerceApp.Services.AddressManagement;

import com.ecommerceApp.ecommerceApp.Dto.AddressManagement.AddressDTO;
import com.ecommerceApp.ecommerceApp.Dto.AddressManagement.AddressRequestDTO;
import com.ecommerceApp.ecommerceApp.Entity.AddressManagement.Address;
import com.ecommerceApp.ecommerceApp.Entity.UserManagement.User;
import com.ecommerceApp.ecommerceApp.Mapper.AddressManagement.AddressMapper;
import com.ecommerceApp.ecommerceApp.Repository.AddressManagement.AddressRepository;
import com.ecommerceApp.ecommerceApp.Repository.UserManagement.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImplements implements AddressService{
    @Autowired
    private AddressRepository addressRepo;

    @Autowired
    private UserRepository userRepo;

    // Create Address
    @Override
    public AddressDTO createAddress(Integer userId, AddressRequestDTO dto) {

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Address address = AddressMapper.toEntity(dto);

        // Important
        address.setUser(user);

        Address saved = addressRepo.save(address);

        return AddressMapper.toDTO(saved);
    }

    // Delete Address
    @Override
    public void deleteAddress(Integer addressId) {

        Address address = addressRepo.findById(addressId)
                .orElseThrow(() -> new RuntimeException("Address not found"));

        addressRepo.delete(address);
    }
}
