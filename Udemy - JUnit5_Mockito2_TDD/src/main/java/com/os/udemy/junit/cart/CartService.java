package com.os.udemy.junit.cart;

import com.os.udemy.junit.order.OrderStatus;

public class CartService {

    private final CartHandler cartHandler;

    public CartService(CartHandler cartHandler) {
        this.cartHandler = cartHandler;
    }

    Cart processCart(Cart cart) {
        if (cartHandler.canHandleCart(cart)) {
            cartHandler.sendToPrepare(cart);
            cart.getOrders().forEach(order -> order.chaneOrderStatus(OrderStatus.PREPARING));
        } else {
            cart.getOrders().forEach(order -> order.chaneOrderStatus(OrderStatus.REJECTED));
        }
        return cart;
    }

    Cart processCart(Cart cart, String msg) {
        if (cartHandler.canHandleCart(cart) && cartHandler.validateCart(cart, msg)) {
            cartHandler.sendToPrepare(cart);
            cart.getOrders().forEach(order -> order.chaneOrderStatus(OrderStatus.PREPARING));
        } else {
            cart.getOrders().forEach(order -> order.chaneOrderStatus(OrderStatus.REJECTED));
        }
        return cart;
    }
}
