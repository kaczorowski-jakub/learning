package com.ocado.basket.promos;

import org.joda.money.Money;

public class Product {

    private final String product;
    private final Money price;

    public Product(final String product, final Money price) {
        this.product = product;
        this.price = price;
    }
    
    public Money getPrice() {
        return price;
    }
    
    public String getProduct() {
        return product;
    }
}
