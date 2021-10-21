package com.ocado.basket.promos;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

public class ExpensiveBasketPromotion implements Promotion {

    private final Money totalBasketValueThreshold;
    private final Money promotionAmount;

    public ExpensiveBasketPromotion(Money totalBasketValueThreshold, Money promotionAmount) {
        this.totalBasketValueThreshold = totalBasketValueThreshold;
        this.promotionAmount = promotionAmount;
    }

    @Override
    public Money calculatePromotion(Basket basket) {
        return basket.totalBasketValue().compareTo(totalBasketValueThreshold) >= 0 ? promotionAmount : Money.of(CurrencyUnit.EUR, 0);
    }
}
