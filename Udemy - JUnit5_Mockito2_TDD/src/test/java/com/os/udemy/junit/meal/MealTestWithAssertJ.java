package com.os.udemy.junit.meal;

import static org.assertj.core.api.Assertions.*;

import com.os.udemy.junit.meal.Meal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MealTestWithAssertJ {

    @Test
    void shouldReturnDiscountedPrice() {
        // given
        Meal meal = new Meal(12);

        // when
        int discountedPrice = meal.getDiscountedPrice(3);

        // then
        assertEquals(9, discountedPrice);
        assertThat(discountedPrice).isEqualTo(9);
    }

    @Test
    void referencesToTheSameObjectShouldBeEqual() {
        // given
        Meal meal1 = new Meal(10);
        Meal meal2 = meal1;

        // then
        assertSame(meal1, meal2);
        assertThat(meal1).isSameAs(meal2);
    }

    @Test
    void referencesToDifferentObjectShouldNotBeEqual() {
        // given
        Meal meal1 = new Meal(10);
        Meal meal2 = new Meal(10);

        // then
        assertNotSame(meal1, meal2);
        assertThat(meal1).isNotSameAs(meal2);
    }

    @Test
    void twoMealsShouldBeEqualWhenPriceAndNameAreTheSame() {
        // given
        Meal meal1 = new Meal(10, "chicken");
        Meal meal2 = new Meal(10, "chicken");

        // then
        assertEquals(meal1, meal2);
        assertThat(meal1).isEqualTo(meal2);
    }
}