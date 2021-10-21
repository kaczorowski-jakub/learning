package com.ocado.basket.promos;

import static org.assertj.core.api.Assertions.assertThat;
import static org.joda.money.CurrencyUnit.EUR;

import java.util.ArrayList;
import java.util.List;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.Before;
import org.junit.Test;

public class PromotionsTest {

	public static Basket SMALL_BASKET = new Basket(){{
        products.put(new Product("mleko", Money.of(EUR, 1.5)), 1);
    }};
    
    public static Basket BIG_BASKET = new Basket(){{
        products.put(new Product("mleko", Money.of(EUR, 1.5)), 101);
    }};
    
    public static Basket MID_BASKET = new Basket(){{
        products.put(new Product("mleko", Money.of(EUR, 0.01)), 41);
    }};
    
    Promotions promotions;
    
    @Before
    public void setup() {
        final BigBasketPromotion bigBasketPromotion = new BigBasketPromotion(40, Money.of(CurrencyUnit.EUR, 5));
        final ExpensiveBasketPromotion expensiveBasketPromotion = new ExpensiveBasketPromotion(
                Money.of(CurrencyUnit.EUR, 100),
                Money.of(CurrencyUnit.EUR, 10)
        );
        List<Promotion> list = new ArrayList<>();
        list.add(bigBasketPromotion);
        list.add(expensiveBasketPromotion);
        promotions = new Promotions(list);
    }
    
    @Test
    public void moneyPromotionsNoPromotion() {
    	assertThat(promotions.processPromotions(SMALL_BASKET)).isEqualTo(Money.of(EUR, 0));
    }
    
    @Test
    public void moneyPromotionsBestPromotion() {
    	assertThat(promotions.processPromotions(BIG_BASKET)).isEqualTo(Money.of(EUR, 10));
    }
    
    @Test
    public void moneyPromotionsBigBasketPromotionPromotion() {
    	assertThat(promotions.processPromotions(MID_BASKET)).isEqualTo(Money.of(EUR, 5));
    }
    
    
}