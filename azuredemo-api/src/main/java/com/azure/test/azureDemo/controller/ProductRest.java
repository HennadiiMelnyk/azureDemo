package com.azure.test.azureDemo.controller;

import com.azure.test.azureDemo.validation.ErrorMessage;
import com.azure.test.azureDemo.domain.Product;
import com.azure.test.azureDemo.service.ProductService;
import com.azure.test.azureDemo.validation.RegexConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.List;

/**
 * Product Rest
 */
@RestController
@Validated
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
        Product productEntity = productService.addProduct(product);
        return ResponseEntity.ok(productEntity);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        final
        List<Product> list = productService.findAll();
        return ResponseEntity.ok(list);
    }

    /**
     * Find product by identifier
     *
     * @param productId
     */
    @GetMapping(value = "/products/{productId}")
    //@ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Product> getProduct(@PathVariable @Pattern(regexp = RegexConstants.UUID_ID, message = ErrorMessage.PRODUCT_ID) String productId) {
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

    /**
     * @param productId
     * @param newProductEntity
     * @return
     */
    @PutMapping("/products/{productId}")
    public ResponseEntity<String> update(@PathVariable String productId, @Valid @RequestBody Product newProductEntity) {
        Product savedProduct = productService.updateProduct(productId, newProductEntity);
        return ResponseEntity.ok(savedProduct.getId());
    }
}
