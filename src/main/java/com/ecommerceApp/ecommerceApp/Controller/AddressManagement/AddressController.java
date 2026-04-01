package com.ecommerceApp.ecommerceApp.Controller.AddressManagement;

import com.ecommerceApp.ecommerceApp.Dto.AddressManagement.AddressDTO;
import com.ecommerceApp.ecommerceApp.Dto.AddressManagement.AddressRequestDTO;
import com.ecommerceApp.ecommerceApp.Services.AddressManagement.AddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    // CREATE ADDRESS
    @PostMapping("/user/{userId}")
    public ResponseEntity<AddressDTO> createAddress(
            @PathVariable Integer userId,
            @RequestBody AddressRequestDTO dto) {

        AddressDTO response = addressService.createAddress(userId, dto);

        return ResponseEntity.status(201).body(response);
    }

    // DELETE ADDRESS
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Integer id) {

        addressService.deleteAddress(id);

        return ResponseEntity.noContent().build();
    }
}
