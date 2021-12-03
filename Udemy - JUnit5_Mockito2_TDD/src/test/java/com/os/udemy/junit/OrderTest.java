package com.os.udemy.junit;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    private Order order;

    @BeforeEach
    void initializeOrder() {
        System.out.println("Initialize");
        order = new Order();
    }

    @AfterEach
    void clearOrder() {
        System.out.println("Clear Order");
        order.cancel();
    }

    @Test
    void testAssertArrayEquals() {

        // given
        int[] ints1 = {1,2,3};
        int[] ints2 = {1,2,3};

        // then
        assertArrayEquals(ints1, ints2);
    }

    @Test
    void mealListShouldBeEmptyAfterOrderCreation() {

        // then
        assertThat(order.getMeals(), empty());
        assertThat(order.getMeals().size(), equalTo(0));
        assertThat(order.getMeals(), hasSize(0));
        assertThat(order.getMeals(), emptyCollectionOf(Meal.class));
    }

    @Test
    void addingMealToOrderShouldIncreaseOrderSize() {
        // given
        Meal meal = new Meal(15, "Burger");
        Meal meal2 = new Meal(5, "Sandwich");

        // when
        order.addMealToOrder(meal);

        // then
        assertThat(order.getMeals(), hasSize(1));
        assertThat(order.getMeals(), contains(meal));
        assertThat(order.getMeals(), hasItem(meal));

        assertThat(order.getMeals().get(0).getPrice(), equalTo(15));
    }

    @Test
    void removingMealFromOrderShouldDecreaseOrderSize() {
        // given
        Meal meal = new Meal(15, "Burger");

        //when
        order.addMealToOrder(meal);
        order.removeMealFromOrder(meal);

        // then
        assertThat(order.getMeals(), hasSize(0));
        assertThat(order.getMeals(), not(contains(meal)));
    }

    @Test
    void mealsSHouldBeInCorrectOrderAfterAddingThemToOrder() {
        // given
        Meal meal = new Meal(15, "Burger");
        Meal meal2 = new Meal(5, "Sandwich");

        // when
        order.addMealToOrder(meal);
        order.addMealToOrder(meal2);

        // then
        assertThat(order.getMeals(), contains(meal, meal2));
        // assertThat(order.getMeals(), contains(meal)); // wrong because it has to be in correct number and order
        assertThat(order.getMeals(), containsInAnyOrder(meal2, meal));
        assertThat(order.getMeals(), hasItem(meal2));
    }

    @Test
    void testIfTwoMealListsAreTheSame() {
        // given
        Meal meal1 = new Meal(15, "Burger");
        Meal meal2 = new Meal(5, "Sandwich");
        Meal meal3 = new Meal(11, "Kebab");
        List<Meal> list1 = Arrays.asList(meal1, meal2);
        List<Meal> list2 = Arrays.asList(meal1, meal2);

        // then
        assertThat(list1, is(list2));
    }
}