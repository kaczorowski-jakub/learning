package com.ocado.basket.promos;

import org.joda.money.Money;

public interface Promotion {
	Money calculatePromotion(Basket basket);
}
