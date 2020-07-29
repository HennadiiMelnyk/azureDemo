package com.azure.test.azureDemo.domain;

import com.azure.test.azureDemo.constants.OrderStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order extends AbstractEntity {
    @Column(name = "orderStatus")
    private OrderStatus orderStatus;
    @Column(name = "details")
    private String details;
    @Column(name = "time")
    private LocalDateTime time;

    private int customer;

    public Order() {
    }


    public Order(String id, OrderStatus orderStatus, String details, LocalDateTime time, int customer) {
        super(id);
        this.orderStatus = orderStatus;
        this.details = details;
        this.time = time;
        this.customer = customer;
    }

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }


    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Order order = (Order) o;
        return orderStatus == order.orderStatus &&
                details.equals(order.details) &&
                time.equals(order.time) &&
                customer == order.customer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), orderStatus, details, time, customer);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderStatus=" + orderStatus +
                ", details='" + details + '\'' +
                ", localDateTime=" + time +
                ", customer=" + customer +
                '}';
    }
}
