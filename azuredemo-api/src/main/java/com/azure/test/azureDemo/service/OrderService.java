package com.azure.test.azureDemo.service;

import com.azure.test.azureDemo.domain.Order;

import java.util.List;

public interface OrderService {
    /**
     *
     * @return
     */
    List<Order> findAll();

    /**
     *
     * @param order
     * @return
     */
    Order createOrder(Order order);
}
