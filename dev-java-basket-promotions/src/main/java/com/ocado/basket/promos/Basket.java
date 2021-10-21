package com.ocado.basket.promos;

import java.util.HashMap;
import java.util.Map;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

public class Basket {

    final Map<Product, Integer> products = new HashMap<>();

    public Money totalBasketValue() {
        return products.entrySet().stream()
                .reduce(Money.of(CurrencyUnit.EUR, 0), 
                        (partial, element) -> partial.plus(element.getKey().getPrice().multipliedBy(element.getValue())), 
                        (a, b) -> a.plus(b));
    }
}
