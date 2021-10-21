package com.ocado.basket.promos;

import java.util.List;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

public class Promotions {
	
	final List<Promotion> list;

    public Promotions(List<Promotion> promotion) {
    	this.list = promotion;
    }
    
    public Money processPromotions(Basket basket) {    	
    	return list.stream().map(p -> p.calculatePromotion(basket)).max(Money::compareTo).orElse(Money.of(CurrencyUnit.EUR, 0));
    }

}
