package com.azure.test.azureDemo.controller;

import com.azure.test.azureDemo.domain.Order;
import com.azure.test.azureDemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Order Rest
 */
@RestController
public class OrderRest {

    private OrderService orderService;

    @Autowired
    public OrderRest(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     *
     * @return
     */
    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.findAll());
    }

    /**
     *
     * @param order
     * @return
     */
    @PostMapping("/order")
    public ResponseEntity<Order> create(@Valid @RequestBody Order order){
        Order orderEntity = orderService.createOrder(order);
        return ResponseEntity.ok(orderEntity);
    }

}
