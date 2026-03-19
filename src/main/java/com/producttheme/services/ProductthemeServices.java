package com.producttheme.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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

		@Override
		public List<Products> getByCategory(String category) {
			return repository.getByCategory(category);
		}

		@Override
		public List<Products> getExpensiveProducts(Double price) {
			return repository.getExpensiveProducts(price);
		}

		@Override
		public List<Products> searchByName(String name) {
			return repository.searchByName(name);
		}

		@Override
		public List<Products> getByPriceRange(Double min, Double max) {
			return repository.getByPriceRange(min, max);
		}

		@Override
		public long checkcountByCategory(String category) {
			return repository.checkcountByCategory(category);
		}
		
		public List<Products> nqfindByNameLike(String name) {
	        return repository.nqfindByNameLike(name);
	    }

	    public List<Products> nqfindByNameNotLike(String pattern) {
	        return repository.nqfindByNameNotLike(pattern);
	    }

	    public List<Products> nqfindByCategoryIn(List<String> categories) {
	        return repository.nqfindByCategoryIn(categories);
	    }

	    public List<Products> nqfindByCategoryNotIn(List<String> categories) {
	        return repository.nqfindByCategoryNotIn(categories);
	    }

	    public List<Products> nqfindCategoryNull() {
	        return repository.nqfindCategoryNull();
	    }

	    public List<Products> nqfindCategoryNotNull() {
	        return repository.nqfindCategoryNotNull();
	    }

	    public List<Products> sortByPriceDesc() {
	        return repository.sortByPriceDesc();
	    }

	    public List<Object[]> countByCategory() {
	        return repository.countByCategory();
	    }
	    
	    public List<Object[]> categoryHavingCount(Long count) {
	        return repository.categoryHavingCount(count);
	    }
	   
	    //tasks
	    public List<String> namesByCategory(String category) {
	        return repository.namesByCategory(category);
	    }

	    public List<Products> priceRange(Double min, Double max) {
	        return repository.priceRange(min, max);
	    }

	    public List<Products> topExpensive() {
	        return repository.topExpensive(PageRequest.of(0, 5));
	    }

	    public long countByPriceRange(Double min, Double max) {
	        return repository.countByPriceRange(min, max);
	    }

	    public List<String> distinctNames() {
	        return repository.distinctNames();
	    }

	    public void updateByName(String name, Double price) {
	    	repository.updateByName(name, price);
	    }

	    public List<String> notAvailableNames() {
	        return repository.notAvailableNames();
	    }

	    public void deleteNotAvailable() {
	    	repository.deleteNotAvailable();
	    }
	    
	    //Native Query
	    public List<Products> nqgetAllProducts() {
	    	return repository.nqgetAllProducts();
	    }
	    
	    public List<Products> nqgetByCategory(String category){
	    	return repository.nqgetByCategory(category);
	    }
	    
	    public List<Products> top5Expensive(){
	    	return repository.top5Expensive();
	    }
}
