package com.azure.test.azureDemo.controller;

import com.azure.test.azureDemo.domain.Product;
import com.azure.test.azureDemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Product Rest
 */
@RestController
public class ProductRest {

    private ProductService productService;

    @Autowired
    public ProductRest(ProductService productService) {
        this.productService = productService;
    }

    /**
     * @param product
     * @return response Entity that was created
     */
    @PostMapping("/product")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Product> create(@Valid @RequestBody Product product) {
        Product productEntity = productService.save(product);
        return ResponseEntity.ok(productEntity);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> list = productService.findAll();
        return ResponseEntity.ok(list);
    }

    /**
     * @param productId
     */
    @GetMapping(value = "/products/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Product> getProduct(@PathVariable("productId") String productId) {
        Product productEntity = productService.findById(productId);
        return ResponseEntity.ok(productEntity);
    }

    /**
     * @param productId
     */
    @DeleteMapping("/products/{productId}")
    public void delete(@PathVariable("productId") String productId) {
        productService.deleteById(productId);
    }
}
