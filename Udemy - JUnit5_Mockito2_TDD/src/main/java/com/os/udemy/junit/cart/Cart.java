package com.os.udemy.junit.cart;

import com.os.udemy.junit.meal.Meal;
import com.os.udemy.junit.order.Order;

import java.util.ArrayList;
import java.util.List;

class Cart {
    private List<Order> orders = new ArrayList<>();

    void addOrderToCart(Order order) {
        this.orders.add(order);
    }

    void clearCart() {
        this.orders.clear();
    }

    void simulateLargeOrder() {
        for (int i = 0 ; i < 1_000 ; i++) {
            Meal meal = new Meal(i%10, "Hamburger no " + i);
            Order order = new Order();
            order.addMealToOrder(meal);
            addOrderToCart(order);
        }
        System.out.println("Cart size: " + orders.size());
        clearCart();
    }

    public List<Order> getOrders() {
        return orders;
    }
}
