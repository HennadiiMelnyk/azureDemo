package com.azure.test.azureDemo.persistence.cart;

import com.azure.test.azureDemo.domain.Product;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class UserCartRepository {

    private Map<Product, Integer> cart;

    public UserCartRepository() {
        cart = new LinkedHashMap<>();
    }

    public void add(Product product) {
        if (cart.containsKey(product)) {
            cart.put(product, cart.get(product) + 1);
        } else {
            cart.put(product, 1);
        }
    }

    public void removeProductFromCart(Product product) {
        cart.remove(product);
    }

    public void removeItemById(int id) {
        Product product = getItemById(id);
        if (product != null) {
            cart.remove(product);
        }
    }

    private Product getItemById(int id) {
        Product product;
        for (Map.Entry entry : cart.entrySet()) {
            product = (Product) entry.getKey();
            if (String.valueOf(product.getId()).equals(id)) {
                return product;
            }
        }
        return null;
    }

    public int getTotalPriceInCart() {
        int total = 0;
        for (Map.Entry entry : cart.entrySet()) {
            int quantity = (int) entry.getValue();
            Product product = (Product) entry.getKey();
            int productPrice = Integer.parseInt(product.getPrice());
            total += productPrice * quantity;
        }
        return total;
    }

    public Map<Product, Integer> getCartProducts() {
        return cart;
    }

    public int getCountCartProducts() {
        return cart.size();
    }

    public void clearCart() {
        cart = new HashMap<>();
    }
}
