package com.producttheme.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.producttheme.model.Products;
import com.producttheme.serviceInterface.ProductthemeInterface;

@RestController
@RequestMapping("/api")
public class Productcontroller {

    @Autowired
    private ProductthemeInterface service;

    @GetMapping("/")
    public String start() {
        return "Hello";
    }

    @GetMapping("/products")
    public List<Products> getProducts() {
        return service.getAllProducts();
    }

    @PostMapping("/addproduct")
    public Products saveProduct(@RequestBody Products product) {
        return service.addProduct(product);
    }
    
    @GetMapping("/products/{id}")
    public Products getProductById(@PathVariable int id){
        return service.getProductById(id);
    }
    
    @PutMapping("/products/{id}")
    public Products updateProduct(@PathVariable int id, @RequestBody Products product){
        return service.updateProduct(id, product);
    }
    
    @DeleteMapping("/delete")
    public String deleteProduct(@RequestBody Products product){
        service.deleteProduct(product);
        return "Product Deleted Successfully";
    }
    
    @GetMapping("/products/search")
    public List<Products> findByName(@RequestParam String name){
        return service.findByName(name);
    }
    
    @GetMapping("/products/cat")
    public List<Products> findByCategory(@RequestParam String category){
        return service.findByCategory(category);
    }
    
    @GetMapping("/products/available")
    public List<Products> getAvailableProducts() {
        return service.getAvailableProducts();
    }
    
    @GetMapping("/products/filter")
    public List<Products> getByCategoryAndAvailability(
            @RequestParam String category,
            @RequestParam Boolean availability) {
        return service.findByCategoryAndAvailability(category, availability);
    }
    
    @GetMapping("/products/find")
    public List<Products> getByNameAndPrice(
            @RequestParam String name,
            @RequestParam Double price) {
        return service.findByNameAndPrice(name, price);
    }
    
    @GetMapping("/products/filterOr")
    public List<Products> getByCategoryOrAvailability(
            @RequestParam String category,
            @RequestParam Boolean availability) {
        return service.findByCategoryOrAvailability(category, availability);
    }
    
    // Price Greater Than
    @GetMapping("/products/price/greater")
    public List<Products> getPriceGreaterThan(@RequestParam Double price) {
        return service.findByPriceGreaterThan(price);
    }

    // Price Less Than
    @GetMapping("/products/price/less")
    public List<Products> getPriceLessThan(@RequestParam Double price) {
        return service.findByPriceLessThan(price);
    }

    // Price Greater Than Equal
    @GetMapping("/products/price/gte")
    public List<Products> getPriceGreaterThanEqual(@RequestParam Double price) {
        return service.findByPriceGreaterThanEqual(price);
    }

    // Price Less Than Equal
    @GetMapping("/products/price/lte")
    public List<Products> getPriceLessThanEqual(@RequestParam Double price) {
        return service.findByPriceLessThanEqual(price);
    }
    
	 // Category is NULL
	 @GetMapping("/products/category/null")
	 public List<Products> getNullCategoryProducts() {
	     return service.getProductsWithNullCategory();
	 }

	 // Category is NOT NULL
	 @GetMapping("/products/category/notnull")
	 public List<Products> getNotNullCategoryProducts() {
	     return service.getProductsWithNotNullCategory();
	 }

    //  Price Between
    @GetMapping("/products/price/between")
    public List<Products> getPriceBetween(
            @RequestParam Double min,
            @RequestParam Double max) {
        return service.findByPriceBetween(min, max);
    }
    
    //count
    @GetMapping("/products/count/category")
    public long getcountByCategory(@RequestParam String category) {
        return service.countByCategory(category);
    }
    
    @GetMapping("/products/count/availability")
    public long getcountByAvailability(@RequestParam Boolean availability) {
        return service.countByAvailability(availability);
    }
    
 // Category IN
    
    @GetMapping("/products/category/in")
    public List<Products> getByCategoryIn(@RequestParam List<String> categories) {
        return service.findByCategoryIn(categories);
    }

    // Category NOT IN
    @GetMapping("/products/category/notin")
    public List<Products> getByCategoryNotIn(@RequestParam List<String> categories) {
        return service.findByCategoryNotIn(categories);
    }
    
    //sorting
 // Sort by Price ASC (Low → High)
    @GetMapping("/products/sort/asc")
    public List<Products> getProductsSortedByPriceAsc(@RequestParam String category) {
        return service.findByCategoryOrderByPriceAsc(category);
    }

    // Sort by Price DESC (High → Low)
    @GetMapping("/products/sort/desc")
    public List<Products> getProductsSortedByPriceDesc(@RequestParam String category) {
        return service.findByCategoryOrderByPriceDesc(category);
    }
    
    //ExistsBy
    @GetMapping("/products/exist/{name}")
    public boolean getByExistName(@PathVariable String name) {
    	return service.existsByName(name);
    }
    
    //Like name
    @GetMapping("/products/searchname")
    public List<Products> searchByName(@RequestParam String name) {
        return service.findByNameContaining(name);
    }

    // NOT LIKE (not contains)
    @GetMapping("/products/searchname/not")
    public List<Products> searchByNameNot(@RequestParam String name) {
        return service.findByNameNotContaining(name);
    }
    
    //Distinct
    @GetMapping("/products/distinct")
    public List<Products> findDistinctByCategory(@RequestParam String category){
    	return service.findDistinctByCategory(category);
    }
}
