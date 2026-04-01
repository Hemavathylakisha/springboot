package com.ecommerceApp.ecommerceApp.Repository.AddressManagement;

import com.ecommerceApp.ecommerceApp.Entity.AddressManagement.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {}
