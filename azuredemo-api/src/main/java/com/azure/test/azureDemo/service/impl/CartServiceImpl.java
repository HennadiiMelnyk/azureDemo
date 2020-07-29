package com.azure.test.azureDemo.service.impl;

import com.azure.test.azureDemo.domain.Product;
import com.azure.test.azureDemo.persistence.cart.UserCartRepository;
import com.azure.test.azureDemo.service.CartService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CartServiceImpl implements CartService {

    private UserCartRepository userCartRepository;


    @Override
    public void addProductToCart(Product product) {
        userCartRepository.add(product);
    }

    @Override
    public void removeProductFromCart(Product product) {
        userCartRepository.removeProductFromCart(product);
    }

    @Override
    public void removeProductById(int id) {
        userCartRepository.removeItemById(id);
    }

    @Override
    public void clearCart() {
        userCartRepository.clearCart();
    }

    @Override
    public int getTotalAmount() {
        return userCartRepository.getTotalPriceInCart();
    }

    @Override
    public Map<Product, Integer> getCartProducts() {
        return userCartRepository.getCartProducts();
    }
}
