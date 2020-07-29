package com.azure.test.azureDemo.service;

import com.azure.test.azureDemo.domain.Product;
import com.azure.test.azureDemo.exception.ResourceNotFoundException;

import java.util.List;

/**
 * Product Service
 */
public interface ProductService {

    /**
     * @return
     */
    List<Product> findAll();

    /**
     * @param product
     */
    Product addProduct(Product product);

    /**
     * @param id
     * @return
     * @throws ResourceNotFoundException
     */
    Product findById(String id) throws ResourceNotFoundException;

    /**
     * @param id
     */
    void deleteById(String id);

    /**
     * @param id
     * @param newProductEntity
     * @return
     */
    Product updateProduct(String id, Product newProductEntity);

    /**
     *  Check existence of product entity
     * @param productId
     * @return
     */
    boolean exists(String productId);
}
