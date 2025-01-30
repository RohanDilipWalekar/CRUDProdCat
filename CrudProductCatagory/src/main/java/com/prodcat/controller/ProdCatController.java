package com.prodcat.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prodcat.dto.ProductDTO;
import com.prodcat.entity.Category;
import com.prodcat.entity.Product;
import com.prodcat.service.ProdCatServ;

@RestController
@RequestMapping("/api")
public class ProdCatController {

	 @Autowired
	    private ProdCatServ prodCatServ;

	    @GetMapping("/categories")
	    public Page<Category> getAllCategories(@RequestParam(value = "page", defaultValue = "0") int page) {
	        return prodCatServ.getAllCategories(page);
	    }

	    @PostMapping("/categories")
	    public Category createCategory(@RequestBody Category category) {
	        return prodCatServ.createCategory(category);
	    }
	    
	    @GetMapping("/categories/{id}")
	    public Optional<Category> getCategoryById(@PathVariable Long id) {
	        return prodCatServ.getCategoryById(id);
	    }

	    @PutMapping("/categories/{id}")
	    public Category updateCategory(@PathVariable Long id, @RequestBody Category categoryDetails) {
	        return prodCatServ.updateCategory(id, categoryDetails);
	    }

	    @DeleteMapping("/categories/{id}")
	    public void deleteCategory(@PathVariable Long id) {
	        prodCatServ.deleteCategory(id);
	    }

	    @PostMapping("/products")
	    public Product createProduct(@RequestBody Product product) {
	        return prodCatServ.createProduct(product);
	    }

	   
	    @GetMapping("/products")
	    public Page<ProductDTO> getAllProducts(Pageable pageable) {
	        return prodCatServ.getAllProducts(pageable);
	    }
	    @GetMapping("/products/{id}")
	    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
	        ProductDTO productDTO = prodCatServ.getProductById(id); // No Optional<Product> needed

	        if (productDTO != null) {
	            return ResponseEntity.ok(productDTO);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    // 4. PUT - update product by ID
	    @PutMapping("/products/{id}")
	    public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
	        return prodCatServ.updateProduct(id, productDetails);
	    }

	    // 5. DELETE - delete product by ID
	    @DeleteMapping("/products/{id}")
	    public void deleteProduct(@PathVariable Long id) {
	        prodCatServ.deleteProduct(id);
	    }
	}