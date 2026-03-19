package com.producttheme.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.producttheme.model.Products;

import jakarta.transaction.Transactional;

@Repository
public interface Productthemerepository extends JpaRepository<Products, Integer>{
	
	//1. Derived Query methods - customized queries
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
	
	//2. JPQL QUERY - for customized queries
	@Query("Select p from Products p where p.category = :category")
	List<Products> getByCategory(@Param("category") String category);

	 // Price greater than
    @Query("SELECT p FROM Products p WHERE p.price > :price")
    List<Products> getExpensiveProducts(@Param("price") Double price);

    // Search by name (LIKE)
    @Query("SELECT p FROM Products p WHERE p.name LIKE %:name%")
    List<Products> searchByName(@Param("name") String name);

    // Price between
    @Query("SELECT p FROM Products p WHERE p.price BETWEEN :min AND :max")
    List<Products> getByPriceRange(@Param("min") Double min,
                                  @Param("max") Double max);

    // Count
    @Query("SELECT COUNT(p) FROM Products p WHERE p.category = :category")
    long checkcountByCategory(@Param("category") String category);
    
    @Query(name = "Products.nqfindByNameLike")
    List<Products> nqfindByNameLike(@Param("name") String name);

    @Query(name = "Products.nqfindByNameNotLike")
    List<Products> nqfindByNameNotLike(@Param("pattern") String pattern);

    @Query(name = "Products.nqfindByCategoryIn")
    List<Products> nqfindByCategoryIn(@Param("categories") List<String> categories);

    @Query(name = "Products.nqfindByCategoryNotIn")
    List<Products> nqfindByCategoryNotIn(@Param("categories") List<String> categories);

    @Query(name = "Products.nqfindCategoryNull")
    List<Products> nqfindCategoryNull();

    @Query(name = "Products.nqfindCategoryNotNull")
    List<Products> nqfindCategoryNotNull();

    @Query(name = "Products.sortByPriceDesc")
    List<Products> sortByPriceDesc();

    @Query(name = "Products.countByCategory")
    List<Object[]> countByCategory();
    
    @Query(name = "Products.categoryHavingCount")
    List<Object[]> categoryHavingCount(@Param("count") Long count);

    //tasks
    @Query(name = "Products.namesByCategory")
    List<String> namesByCategory(@Param("category") String category);

    @Query(name = "Products.priceRange")
    List<Products> priceRange(@Param("min") Double min, @Param("max") Double max);

    @Query(name = "Products.topExpensive")
    List<Products> topExpensive(PageRequest pageRequest);

    @Query(name = "Products.countByPriceRange")
    long countByPriceRange(@Param("min") Double min, @Param("max") Double max);

    @Query(name = "Products.distinctNames")
    List<String> distinctNames();

    @Modifying
    @Transactional
    @Query(name = "Products.updateByName")
    void updateByName(@Param("name") String name, @Param("price") Double price);

    @Query(name = "Products.notAvailableNames")
    List<String> notAvailableNames();

    @Modifying
    @Transactional
    @Query(name = "Products.deleteNotAvailable")
    void deleteNotAvailable();
    
    //Native Query
    @Query(value="Select * from Products", nativeQuery=true)
    List<Products> nqgetAllProducts();
    
    @Query(value = "SELECT * FROM products WHERE category = :category", nativeQuery = true)
    List<Products> nqgetByCategory(String category);
    
    // Top 5 Expensive Products
    @Query(value = "SELECT * FROM products ORDER BY price DESC LIMIT 5", nativeQuery = true)
    List<Products> top5Expensive();
}
