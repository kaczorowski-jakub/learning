package com.os.udemy.junit.meal;

import static org.junit.jupiter.api.DynamicTest.*;

import com.os.udemy.junit.extensions.IAExceptionIgnoreExtension;
import com.os.udemy.junit.meal.Meal;
import com.os.udemy.junit.order.Order;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.spy;

class MealTest {

    @Spy
    private Meal mealSpy;

    @Test
    void shouldReturnDiscountedPrice() {
        // given
        Meal meal = new Meal(12);

        // when
        int discountedPrice = meal.getDiscountedPrice(3);

        // then
        assertEquals(9, discountedPrice);
        assertThat(discountedPrice, equalTo(9));
    }

    @Test
    void referencesToTheSameObjectShouldBeEqual() {
        // given
        Meal meal1 = new Meal(10);
        Meal meal2 = meal1;

        // then
        assertSame(meal1, meal2);
        assertThat(meal1, sameInstance(meal2));
    }

    @Test
    void referencesToDifferentObjectShouldNotBeEqual() {
        // given
        Meal meal1 = new Meal(10);
        Meal meal2 = new Meal(10);

        // then
        assertNotSame(meal1, meal2);
        assertThat(meal1, not(sameInstance(meal2)));
    }

    @Test
    void twoMealsShouldBeEqualWhenPriceAndNameAreTheSame() {
        // given
        Meal meal1 = new Meal(10, "chicken");
        Meal meal2 = new Meal(10, "chicken");

        // then
        assertEquals(meal1, meal2);
    }

    @Test
    void exceptionShouldBeThrownIfDiscountIsHigherThanThePrice() {
        // given
        Meal meal = new Meal(8, "Soup");

        // when + then
        assertThrows(IllegalArgumentException.class, () -> meal.getDiscountedPrice(12));
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 10, 15, 18})
    void mealPricesShouldBeLowerThan20(int price) {
        assertThat(price, lessThan(20));
    }

    @ParameterizedTest
    @MethodSource("createMealsWithNameAndPrice")
    void burgerShouldHaveCorrectNameAndPrice(String name, int price) {
        assertThat(name, containsString("burger"));
        assertThat(price, greaterThanOrEqualTo(10));
    }

    private static Stream<Arguments> createMealsWithNameAndPrice() {
        return Stream.of(Arguments.of("Hamburger", 10), Arguments.of("Cheeseburger", 12));
    }

    @ParameterizedTest
    @MethodSource("createCakeNames")
    void cakeNameShouldEndWithCake(String name) {
        assertThat(name, notNullValue());
        assertThat(name, endsWith("cake"));
    }

    private static Stream<String> createCakeNames() {
        List<String> list = Arrays.asList("Cheesecake", "Fruitcake", "Cupcake");
        return list.stream();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 8})
    @ExtendWith(IAExceptionIgnoreExtension.class)
    void mealPricesShouldBeLowerThan10(int price) {
        if (price > 5) {
            throw new IllegalArgumentException();
        }
        assertThat(price, lessThan(10));
    }

    @TestFactory
    Collection<DynamicTest> dynamicTestsCollection() {
        return Arrays.asList(
            dynamicTest("Dynamic Test 1", () -> assertThat(5, lessThan(6))),
            dynamicTest("Dynamic Test 2", () -> assertEquals(4, 2*2))
        );
    }

    @Tag("fries")
    @TestFactory
    Collection<DynamicTest> calculateMealPrices() {
        Order order = new Order();
        order.addMealToOrder(new Meal(10, "Hamburger", 2));
        order.addMealToOrder(new Meal(7, "Fries", 4));
        order.addMealToOrder(new Meal(22, "Pizza", 3));

        Collection<DynamicTest> dynamicTests = new ArrayList<>();

        for (int i = 0 ; i < order.getMeals().size() ; i++) {
            int price = order.getMeals().get(i).getPrice();
            int quantity = order.getMeals().get(0).getQuantity();

            Executable executable = () -> {
                assertThat(calculatePrice(price, quantity), lessThan(67));
            };

            String name = "Test name: " + i;
            dynamicTests.add(DynamicTest.dynamicTest(name, executable));
        }

        return dynamicTests;
    }

    private int calculatePrice(int price, int quantity) {
        return price * quantity;
    }

    @Test
    void testMealSumPrice() {

        // given
        Meal meal = mock(Meal.class);
        given(meal.getPrice()).willReturn(15);
        given(meal.getQuantity()).willReturn(3);
        given(meal.sumPrice()).willCallRealMethod();    // without this one sumPrice will return default = 0

        // when
        int result = meal.sumPrice();

        // then
        assertThat(result, equalTo(45));
    }

    @Test
    @ExtendWith(MockitoExtension.class)
    void testMealSumPriceWithSpy() {

        // given
        /* because we have @Spy
        Meal meal = new Meal(14, "burrito", 4);
        Meal mealSpy = spy(meal);
        */

        given(mealSpy.getPrice()).willReturn(15);
        given(mealSpy.getQuantity()).willReturn(3);

        // when
        int result = mealSpy.sumPrice();

        // then
        then(mealSpy).should().getPrice();
        then(mealSpy).should().getQuantity();
        assertThat(result, equalTo(45));
    }
}