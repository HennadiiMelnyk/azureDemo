package com.azure.test.azureDemo.service.impl;

import com.azure.test.azureDemo.domain.Order;
import com.azure.test.azureDemo.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public Order createOrder(Order order) {
        return null;
    }
}
