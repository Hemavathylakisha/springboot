package com.producttheme.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
@NamedQueries({
	
	//LIKE
	 @NamedQuery(name = "Products.nqfindByNameLike",query = "SELECT p FROM Products p WHERE p.name LIKE CONCAT('%', :name, '%')"),
	 // NOT LIKE
	@NamedQuery(name = "Products.nqfindByNameNotLike",query = "SELECT p FROM Products p WHERE p.name NOT LIKE CONCAT(:pattern, '%')"),
    // IN
    @NamedQuery(name = "Products.nqfindByCategoryIn",query = "SELECT p FROM Products p WHERE p.category IN :categories"),
    // NOT IN
    @NamedQuery(name = "Products.nqfindByCategoryNotIn",query = "SELECT p FROM Products p WHERE p.category NOT IN :categories"),
    // IS NULL
    @NamedQuery(name = "Products.nqfindCategoryNull",query = "SELECT p FROM Products p WHERE p.category IS NULL"),
    // IS NOT NULL
    @NamedQuery(name = "Products.nqfindCategoryNotNull",query = "SELECT p FROM Products p WHERE p.category IS NOT NULL"),
    // ORDER BY
    @NamedQuery( name = "Products.sortByPriceDesc",query = "SELECT p FROM Products p ORDER BY p.price DESC"),
    // GROUP BY
    @NamedQuery(name = "Products.countByCategory",query = "SELECT p.category, COUNT(p) FROM Products p GROUP BY p.category"),
    // HAVING
    @NamedQuery( name = "Products.categoryHavingCount",query = "SELECT p.category, COUNT(p) FROM Products p GROUP BY p.category HAVING COUNT(p) > :count"),
//    // DISTINCT
//    @NamedQuery(
//        name = "Products.distinctCategories",
//        query = "SELECT DISTINCT p.category FROM Products p"
//    ),
//
//    // UPDATE
//    @NamedQuery(
//        name = "Products.updatePrice",
//        query = "UPDATE Products p SET p.price = :price WHERE p.id = :id"
//    ),
//
//    // DELETE
//    @NamedQuery(
//        name = "Products.deleteUnavailable",
//        query = "DELETE FROM Products p WHERE p.availability = false"
//    ),
//
//    // AGGREGATE
//    @NamedQuery(
//        name = "Products.avgPrice",
//        query = "SELECT AVG(p.price) FROM Products p"
//    ),
//
//    // SUBQUERY
//    @NamedQuery(
//        name = "Products.aboveAveragePrice",
//        query = "SELECT p FROM Products p WHERE p.price > (SELECT AVG(p2.price) FROM Products p2)"
//    ),
//
//    // EXISTS
//    @NamedQuery(
//        name = "Products.existsCategory",
//        query = "SELECT p FROM Products p WHERE EXISTS (SELECT 1 FROM Products p2 WHERE p2.category = p.category)"
//    ),
//
//    // CASE WHEN
//    @NamedQuery(
//        name = "Products.caseAvailability",
//        query = "SELECT p.name, CASE WHEN p.availability = true THEN 'Available' ELSE 'Out of Stock' END FROM Products p"
//    )

    //tasks
    // Product by Category → only name
    @NamedQuery(name = "Products.namesByCategory",query = "SELECT p.name FROM Products p WHERE p.category = :category"),
    // Price Range Filter
    @NamedQuery(name = "Products.priceRange", query = "SELECT p FROM Products p WHERE p.price BETWEEN :min AND :max"),
    // Top 5 Expensive Products
    @NamedQuery(name = "Products.topExpensive",query = "SELECT p FROM Products p ORDER BY p.price DESC"),
    // Count with price range
    @NamedQuery(name = "Products.countByPriceRange",query = "SELECT COUNT(p) FROM Products p WHERE p.price BETWEEN :min AND :max"),
    // Distinct product names
    @NamedQuery(name = "Products.distinctNames",query = "SELECT DISTINCT p.name FROM Products p"),
    // Update by name
    @NamedQuery(name = "Products.updateByName",query = "UPDATE Products p SET p.price = :price WHERE p.name = :name"),
    // Not available → only names
    @NamedQuery(name = "Products.notAvailableNames", query = "SELECT p.name FROM Products p WHERE p.availability = false"),
    // Delete not available
    @NamedQuery(name = "Products.deleteNotAvailable",query = "DELETE FROM Products p WHERE p.availability = false")

})

public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double price;

    private String category;

    private Boolean availability;

    public Products() {}

    public Products(String name, Double price, String category, Boolean availability) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.availability = availability;
    }

    // getters & setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Products [id=" + id + ", name=" + name + ", price=" + price + ", category=" + category + ", availability=" + availability + "]";
    }
}
