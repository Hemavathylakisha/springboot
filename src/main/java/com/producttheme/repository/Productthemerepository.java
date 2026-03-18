package com.producttheme.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.producttheme.model.Products;

@Repository
public interface Productthemerepository extends JpaRepository<Products, Integer>{
	
	//Derived Query methods - customized queries
	List<Products> findByName(String name);
	
	List<Products> findByCategory(String category);

	List<Products> findByAvailabilityTrue();
	
	//AND OR operations - Logical
	List<Products> findByCategoryAndAvailability(String category, Boolean availability);

	List<Products> findByNameAndPrice(String name, Double price);

	List<Products> findByCategoryOrAvailability(String category, Boolean availability);
	
	//Comparison 
	List<Products> findByPriceGreaterThan(Double price);

	List<Products> findByPriceLessThan(Double price);

	List<Products> findByPriceGreaterThanEqual(Double price);

	List<Products> findByPriceLessThanEqual(Double price);

	List<Products> findByPriceBetween(Double min, Double max);
	
	//Null checks
	List<Products> findByCategoryIsNull();

	List<Products> findByCategoryIsNotNull();
	
	//count
	long countByCategory(String category);

	long countByAvailability(Boolean availability);
	
	//In/NotIn
	List<Products> findByCategoryIn(List<String> categories);

	List<Products> findByCategoryNotIn(List<String> categories);
	
	//Sorting
	List<Products> findByCategoryOrderByPriceAsc(String category);
	
	List<Products> findByCategoryOrderByPriceDesc(String category);

	//ExistBy
	boolean existsByName(String name);

	//String pattern 
	List<Products> findByNameContaining(String name);     // %value%

	List<Products> findByNameNotContaining(String name);  // NOT LIKE

	//Distinct
	List<Products> findDistinctByCategory(String category);
}
