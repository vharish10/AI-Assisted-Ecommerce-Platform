package com.Revature.Ecommerce.Platform.repository;

import com.Revature.Ecommerce.Platform.models.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Products, Long> {

    //Search by Name
    Page<Products> findByNameContainingIgnoreCase(String name, Pageable pageable);

    //Seach by category
    Page<Products> findByCategory(String category, Pageable pageable);

    //Search by brand
    Page<Products> findByBrand(String brand, Pageable pageable);

    //search by price
    Page<Products> findByPriceBetween(Double minPrice, Double maxPrice, Pageable pageable);
}
