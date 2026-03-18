package com.producttheme.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.producttheme.model.Products;
import com.producttheme.repository.Productthemerepository;
import com.producttheme.serviceInterface.ProductthemeInterface;

@Service
public class ProductthemeServices implements ProductthemeInterface{
	 	@Autowired
	    private Productthemerepository repository;

	    @Override
	    public List<Products> getAllProducts() {
	        return repository.findAll();
	    }
	    
	    @Override
	    public Products addProduct(Products product){
	       return repository.save(product);
	    }
	    
	    @Override
	    public Products getProductById(int id) {
	    	return repository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
	    }

		@Override
		public Products updateProduct(int id, Products product) {
			Products existingProduct =repository.findById(id)
	        .orElseThrow(() -> new RuntimeException("Product not found"));
		
			existingProduct.setName(product.getName());
		    existingProduct.setPrice(product.getPrice());
		    existingProduct.setCategory(product.getCategory());
		    existingProduct.setAvailability(product.isAvailability());

		    return repository.save(existingProduct);
		}
	    
		@Override
		public void deleteProduct(Products product){
		    repository.delete(product);
		}
		
		//customize - by name
		@Override
		public List<Products> findByName(String name){
			return repository.findByName(name);
		}
		
		//customize - by category
		@Override
		public List<Products> findByCategory(String category){
			return repository.findByCategory(category);		
		}
		
		//customize - by availability
		@Override
		public List<Products> getAvailableProducts(){
			return repository.findByAvailabilityTrue();		
		}

		@Override
		public List<Products> findByCategoryAndAvailability(String category, Boolean availability) {
			return repository.findByCategoryAndAvailability(category, availability);
		}

		@Override
		public List<Products> findByNameAndPrice(String name, Double price) {
			return repository.findByNameAndPrice(name, price);
		}

		@Override
		public List<Products> findByCategoryOrAvailability(String category, Boolean availability) {
			return repository.findByCategoryOrAvailability(category, availability);
		}

		@Override
		public List<Products> findByPriceGreaterThan(Double price) {
			return repository.findByPriceGreaterThan(price);
		}

		@Override
		public List<Products> findByPriceLessThan(Double price) {
			return repository.findByPriceLessThan(price);
		}

		@Override
		public List<Products> findByPriceGreaterThanEqual(Double price) {
			return repository.findByPriceGreaterThanEqual(price);
		}

		@Override
		public List<Products> findByPriceLessThanEqual(Double price) {
			return repository.findByPriceLessThanEqual(price);
		}

		@Override
		public List<Products> findByPriceBetween(Double min, Double max) {
			return repository.findByPriceBetween(min, max);
		}	
		
		@Override
		public List<Products> getProductsWithNullCategory() {
		    return repository.findByCategoryIsNull();
		}

		@Override
		public List<Products> getProductsWithNotNullCategory() {
		    return repository.findByCategoryIsNotNull();
		}

		@Override
		public long countByCategory(String category) {
			return repository.countByCategory(category);
		}

		@Override
		public long countByAvailability(Boolean availability) {
			return repository.countByAvailability(availability);
		}
		
		@Override
		public List<Products> findByCategoryIn(List<String> Category){
			return repository.findByCategoryIn(Category);
		}

		@Override
		public List<Products> findByCategoryNotIn(List<String> categories) {
			return repository.findByCategoryNotIn(categories);
		}
		
		@Override
		public List<Products> findByCategoryOrderByPriceAsc(String category){
			return repository.findByCategoryOrderByPriceAsc(category);
		}

		@Override
		public List<Products> findByCategoryOrderByPriceDesc(String category) {
			return repository.findByCategoryOrderByPriceDesc(category);
		}

		@Override
		public boolean existsByName(String name) {
		return repository.existsByName(name);
		}

		@Override
		public List<Products> findByNameContaining(String name) {
			return repository.findByNameContaining(name);
		}

		@Override
		public List<Products> findByNameNotContaining(String name) {
			return repository.findByNameNotContaining(name);
		}

		@Override
		public List<Products> findDistinctByCategory(String category) {
			return repository.findDistinctByCategory(category);
		}
}
