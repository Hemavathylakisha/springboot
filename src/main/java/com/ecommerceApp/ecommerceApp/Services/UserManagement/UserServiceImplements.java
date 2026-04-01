package com.ecommerceApp.ecommerceApp.Services.UserManagement;

import com.ecommerceApp.ecommerceApp.Dto.UserManagement.UserRequestDTO;
import com.ecommerceApp.ecommerceApp.Dto.UserManagement.UserResponseDTO;
import com.ecommerceApp.ecommerceApp.Entity.ProductManagement.Product;
import com.ecommerceApp.ecommerceApp.Entity.UserManagement.User;
import com.ecommerceApp.ecommerceApp.Mapper.UserManagement.UserMapper;
import com.ecommerceApp.ecommerceApp.Repository.ProductManagement.ProductRepository;
import com.ecommerceApp.ecommerceApp.Repository.UserManagement.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplements implements UserService{
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private ProductRepository productRepo;

    //To get full details
    @Override
    public UserResponseDTO getUserFullDetails(Integer userId) {

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found " + userId));

        return UserMapper.toDTO(user);
    }

    @Override
    public UserResponseDTO createUser(UserRequestDTO dto) {
        //  Fetch products from DB
        List<Product> products = productRepo.findAllById(dto.getProductIds());

        // Pass products to mapper
        User user = UserMapper.toEntity(dto, products);

        User savedUser = userRepo.save(user);

        return UserMapper.toDTO(savedUser);
    }

    //delete
    @Override
    public void deleteUser(Integer id) {
        userRepo.deleteById(id);
    }
}
