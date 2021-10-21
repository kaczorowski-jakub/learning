package com.ocado.basket.promos;

import static org.assertj.core.api.Assertions.assertThat;
import static org.joda.money.CurrencyUnit.EUR;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.Test;

public class BigBasketPromotionTest {
	public static Basket SMALL_BASKET = new Basket(){{
        products.put(new Product("mleko", Money.of(EUR, 1.5)), 1);
    }};
    
    public static Basket MID_BASKET = new Basket(){{
        products.put(new Product("mleko", Money.of(EUR, 1.5)), 100);
    }};
    
    public static Basket BIG_BASKET = new Basket(){{
        products.put(new Product("mleko", Money.of(EUR, 1.5)), 101);
    }};
    
    BigBasketPromotion bigiBasketPromotion = new BigBasketPromotion(100, Money.of(CurrencyUnit.EUR, 16));
    
    @Test
    public void moneySmallBasketNoBigBasketPromotion() {
    	assertThat(bigiBasketPromotion.calculatePromotion(SMALL_BASKET)).isEqualTo(Money.of(EUR, 0));
    }
    
    @Test
    public void moneyMidBasketBigBasketPromotionExists() {
    	assertThat(bigiBasketPromotion.calculatePromotion(MID_BASKET)).isEqualTo(Money.of(EUR, 0));
    }
    
    @Test
    public void moneyBigBasketBigBasketPromotionExists() {
    	assertThat(bigiBasketPromotion.calculatePromotion(MID_BASKET)).isEqualTo(Money.of(EUR, 0));
    }
    
}
