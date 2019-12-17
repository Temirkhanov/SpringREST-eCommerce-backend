package com.goruslan.eCommerce.controller;

import com.goruslan.eCommerce.entity.Product;
import com.goruslan.eCommerce.entity.ProductCategory;
import com.goruslan.eCommerce.exception.NotFoundException;
import com.goruslan.eCommerce.repository.ProductCategoryRepository;
import com.goruslan.eCommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    // All Products
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    // Specific Product
    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable long id) {
        Optional<Product> product = productRepository.findById(id);
        if(!product.isPresent()){
            throw new NotFoundException("id - " + id);
        }
        return product.get();
    }

    // Get All Categories
    @GetMapping("/categories")
    public List<ProductCategory> getAllCategories(){
        return productCategoryRepository.findAll();
    }

    // Get the Category
    @GetMapping("/categories/{id}")
    public ProductCategory getProductsByCategory(@PathVariable Long id){
        Optional<ProductCategory> category = productCategoryRepository.findById(id);
        if(!category.isPresent())
            throw new NotFoundException("catId - " + id);
        return category.get();
    }


}