package com.azure.test.azureDemo.service.impl;

import com.azure.test.azureDemo.domain.Product;
import com.azure.test.azureDemo.exception.ResourceNotFoundException;
import com.azure.test.azureDemo.persistence.ProductRepository;
import com.azure.test.azureDemo.service.ProductService;
import com.azure.test.azureDemo.validation.ErrorMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for products
 */
@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findById(String id) throws ResourceNotFoundException {
        return productRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Product  doesn't exist with id: " + id));
    }

    @Override
    public void deleteById(String id) {
        if (exists(id)) {
            productRepository.deleteById(id);
            LOG.info("User has just deleted the product with id: " + id);
        } else {
            throw new ResourceNotFoundException(ErrorMessage.PRODUCT_WITH_SPECIFIED_ID_DOES_NOT_EXIST);
        }

    }

    @Override
    public Product updateProduct(String id, Product newProductEntity) {
        Product oldEntity = findById(id);
        oldEntity.setDescription(newProductEntity.getDescription());
        oldEntity.setPrice(newProductEntity.getPrice());
        oldEntity.setColor(newProductEntity.getColor());
        oldEntity.setName(newProductEntity.getName());
        oldEntity.setId(newProductEntity.getId());
        return productRepository.save(oldEntity);
    }

    @Override
    public boolean exists(String productId) {
        return productRepository.existsById(productId);
    }
}
