package com.azure.test.azureDemo.service;

import com.azure.test.azureDemo.domain.Product;

import java.util.Map;

public interface CartService {
    /**
     * @param product
     */
    void addProductToCart(Product product);

    /**
     * @param product
     */
    void removeProductFromCart(Product product);

    /**
     *
     * @param id
     */
    void removeProductById(int id);

    /**
     * clear cart
     */
    void clearCart();

    /**
     *
     * @return amount of product in the cart
     */
    int getTotalAmount();

    /**
     *
     * @return
     */
    Map<Product, Integer> getCartProducts();
}
