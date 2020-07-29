package com.azure.test.azureDemo.persistence;

import com.azure.test.azureDemo.domain.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends BaseRepository<Order, String> {
}
