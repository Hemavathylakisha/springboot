package com.producttheme.serviceInterface;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.producttheme.model.Products;

public interface ProductthemeInterface {
	//To get all products
    List<Products> getAllProducts();
    
    //To add product
	Products addProduct(Products product);
	
	//To fetch by id
	Products getProductById(int id);
	
	//To update 
	Products updateProduct(int id, Products product);

	//To delete by object
	void deleteProduct(Products product);
	
	//To customize query - by name
	List<Products> findByName(String name);

	//To customize query - by category
	List<Products> findByCategory(String category);

	//To customize query - by availability check
	List<Products> getAvailableProducts();
	
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

	List<Products> getProductsWithNullCategory();

	List<Products> getProductsWithNotNullCategory();
	
	//Count 
	long countByCategory(String category);

	long countByAvailability(Boolean availability);
	
	//In/NotIn
	List<Products> findByCategoryIn(List<String> categories);

	List<Products> findByCategoryNotIn(List<String> categories);

	//Sorting
	List<Products> findByCategoryOrderByPriceAsc(String category);
		
	List<Products> findByCategoryOrderByPriceDesc(String category);
	
	//Existby
	boolean existsByName(String name);
	
	//string pattern
	List<Products> findByNameContaining(String name);     // %value%

	List<Products> findByNameNotContaining(String name);  // NOT LIKE

	//distinct
	List<Products> findDistinctByCategory(String category);
	
	//2.JPQL 
	List<Products> getByCategory(@Param("category") String category);
	
	List<Products> getExpensiveProducts(Double price);

    List<Products> searchByName(String name);

    List<Products> getByPriceRange(Double min, Double max);

    long checkcountByCategory(String category);
    
    //named queries
    List<Products> nqfindByNameLike(@Param("name") String name);
    
    List<Products> nqfindByNameNotLike(@Param("pattern") String pattern);
    
    List<Products> nqfindByCategoryIn(@Param("categories") List<String> categories);
    
    List<Products> nqfindByCategoryNotIn(@Param("categories") List<String> categories);

    List<Products> nqfindCategoryNull();
    
    List<Products> nqfindCategoryNotNull();
    
    List<Products> sortByPriceDesc();
    
    List<Object[]> countByCategory();
    
    List<Object[]> categoryHavingCount(Long count);
    
    //tasks
    List<String> namesByCategory(String category);

    List<Products> priceRange(Double min, Double max);

    List<Products> topExpensive();

    long countByPriceRange(Double min, Double max);

    List<String> distinctNames();

    void updateByName(String name, Double price);

    List<String> notAvailableNames();

    void deleteNotAvailable();

    //Native Query
    List<Products> nqgetAllProducts();
    
    List<Products> nqgetByCategory(String category);
    
    List<Products> top5Expensive();
}
