package com.ocado.basket.promos;

import static org.assertj.core.api.Assertions.assertThat;
import static org.joda.money.CurrencyUnit.EUR;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.Test;

public class ExpensiveBasketPromotionTest {
	ExpensiveBasketPromotion expensiveBasketPromotion = new ExpensiveBasketPromotion(Money.of(CurrencyUnit.EUR, 200), Money.of(CurrencyUnit.EUR, 20));
	
	public static Basket CHEAP_BASKET = new Basket(){{
        products.put(new Product("mleko", Money.of(EUR, 1.5)), 1);
    }};

    public static Basket EXPENSIVE_BASKET = new Basket(){{
        products.put(new Product("mleko", Money.of(EUR, 1.5)), 200);
    }};
    
    @Test
    public void moneySmallBasketNoExpensivePromotion() {
    	assertThat(expensiveBasketPromotion.calculatePromotion(CHEAP_BASKET)).isEqualTo(Money.of(EUR, 0));
    }
    
    @Test
    public void moneyBigBasketExpensivePromotionExists() {
    	assertThat(expensiveBasketPromotion.calculatePromotion(EXPENSIVE_BASKET)).isEqualTo(Money.of(EUR, 20));
    }
}
