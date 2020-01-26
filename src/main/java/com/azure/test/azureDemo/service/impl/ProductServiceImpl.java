package com.azure.test.azureDemo.service.impl;

import com.azure.test.azureDemo.domain.Product;
import com.azure.test.azureDemo.exception.ResourceNotFoundException;
import com.azure.test.azureDemo.persistence.ProductRepository;
import com.azure.test.azureDemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product save(Product product) {
       return productRepository.save(product);
    }

    @Override
    public Product findById(String id) throws ResourceNotFoundException {
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product  doesn't exist with id: " + id));
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }

    @Override
    public void deleteById(String id) {
        productRepository.deleteById(id);
    }
}
