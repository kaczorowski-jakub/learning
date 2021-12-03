package com.os.udemy.junit;

import static org.hamcrest.MatcherAssert.*;

import static org.hamcrest.core.AnyOf.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test cases for Cart")
class CartTest {

    @Test
    @DisplayName("Carts is able to process 1000 orders in 10ms")
    void simpulateLargeOrrder() {
        // given
        Cart cart = new Cart();

        // when + then
        assertTimeout(Duration.ofMillis(10), cart::simulateLargeOrder);
    }

    @Test
    void cartShouldNotBeEmptyAfterAddingOrderToIt() {
        // given
        Order order = new Order();
        Cart cart = new Cart();

        // when
        cart.addOrderToCart(order);

        //then
        assertThat(cart.getOrders(), anyOf(
                notNullValue(),
                hasSize(1),
                is(not(empty())),
                is(not(emptyCollectionOf(Order.class)))
        ));

//        assertThat(cart.getOrders(), anyOf(
//                nullValue(),
//                hasSize(0),
//                is(empty()),
//                is(emptyCollectionOf(Order.class))
//        ));

        assertThat(cart.getOrders(), allOf(
                notNullValue(),
                hasSize(1),
                is(not(empty())),
                is(not(emptyCollectionOf(Order.class)))
        ));

        // only one failed assertion will be printed
//        assertThat(cart.getOrders(), allOf(
//                nullValue(),
//                hasSize(0),
//                is(not(empty())),
//                is(not(emptyCollectionOf(Order.class)))
//        ));

        assertAll(
                () -> assertThat(cart.getOrders(), notNullValue()),
                () -> assertThat(cart.getOrders(), hasSize(1)),
                () -> assertThat(cart.getOrders(), is(not(empty()))),
                () -> assertThat(cart.getOrders().get(0).getMeals(), empty())
        );

        // all of the assertions will be processed:
//        assertAll(
//                () -> assertThat(cart.getOrders(), nullValue()),
//                () -> assertThat(cart.getOrders(), hasSize(0)),
//                () -> assertThat(cart.getOrders(), is(not(empty()))),
//                () -> assertThat(cart.getOrders().get(0).getMeals(), empty())
//        );

    }
}