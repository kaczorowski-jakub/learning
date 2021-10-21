package com.ocado.basket.promos;

import java.util.Map;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

public class BigBasketPromotion implements Promotion {

    private final int minItemsThreshold;
    private final Money promotionAmount;

    public BigBasketPromotion(int minItemsThreshold, Money promotionAmount) {
        this.minItemsThreshold = minItemsThreshold;
        this.promotionAmount = promotionAmount;
    }
    
    @Override
    public Money calculatePromotion(Basket basket) {
        return items(basket.products) > minItemsThreshold ? promotionAmount : Money.of(CurrencyUnit.EUR, 0);
    }

    private int items(Map<Product, Integer> products) {
    	return products.values().stream().reduce(0, Integer::sum);
    }
}
