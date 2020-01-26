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
    Product save(Product product);

    /**
     * @param id
     * @return
     * @throws ResourceNotFoundException
     */
    Product findById(String id) throws ResourceNotFoundException;

    /**
     * @param product
     */
    void delete(Product product);

    /**
     *
     * @param id
     */
    void deleteById(String id);
}
