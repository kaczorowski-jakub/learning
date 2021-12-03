package com.os.udemy.junit.cart;

public interface CartHandler {
        boolean canHandleCart(Cart cart);
        void sendToPrepare(Cart cart);
        boolean validateCart(Cart cart, String errorMessage);
}
