package com.azure.test.azureDemo.persistence;

import com.azure.test.azureDemo.domain.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends BaseRepository<Product, String> {

}
