package com.os.udemy.junit.meal;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import com.os.udemy.junit.meal.Meal;
import com.os.udemy.junit.meal.MealRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MealRepoTest {

    private MealRepo mealRepo = new MealRepo();

    @BeforeEach
    void cleanUp() {
        mealRepo.getAllMeals().clear();
    }

    @Test
    void shouldBeAbleToAddMealToRepository() {
        // given
        Meal meal = new Meal(10, "Pizza");

        // when
        mealRepo.add(meal);

        // then
        assertThat(mealRepo.getAllMeals().get(0), is(meal));
    }

    @Test
    void shouldBeAbleToRemoveMealFromRepository() {
        // given
        Meal meal = new Meal(10, "Pizza");
        mealRepo.add(meal);

        // when
        mealRepo.delete(meal);

        // then
        assertThat(mealRepo.getAllMeals(), not(contains(meal)));
    }

    @Test
    void shouldBeAbleToFindMealByExactName() {
        // given
        Meal meal = new Meal(10, "Pizza");
        Meal meal2 = new Meal(10, "Pi");
        mealRepo.add(meal);
        mealRepo.add(meal2);

        // when
        List<Meal> results = mealRepo.findByName("Pizza", true);

        // then
        assertThat(results.size(), is(1));
    }

    @Test
    void shouldBeAbleToFindMealByStartingLetters() {
        // given
        Meal meal = new Meal(10, "Pizza");
        Meal meal2 = new Meal(10, "Pi");
        mealRepo.add(meal);
        mealRepo.add(meal2);

        // when
        List<Meal> results = mealRepo.findByName("P", false);

        // then
        assertThat(results.size(), is(2));
    }

    @Test
    void shouldBeAbleFindMealByPrice() {
        // given
        Meal meal = new Meal(10, "Pizza");
        mealRepo.add(meal);

        // when
        List<Meal> results = mealRepo.findByPrice(10);

        // then
        assertThat(results.size(), is(1));
    }

    @Test
    void shouldBeAbleToFindMealByPriceGreaterThan() {
        // given
        Meal meal1 = new Meal(10, "Pizza");
        Meal meal2 = new Meal(15, "Pizza+");
        mealRepo.add(meal1);
        mealRepo.add(meal2);

        // when
        List<Meal> results = mealRepo.findByPrice(5, MealRepo.PriceCond.GREATER);

        // then
        assertThat(results.size(), is (2));
    }

    @Test
    void shouldBeAbleToFindMealByPriceLowerThan() {
        // given
        Meal meal1 = new Meal(10, "Pizza");
        Meal meal2 = new Meal(15, "Pizza+");
        mealRepo.add(meal1);
        mealRepo.add(meal2);

        // when
        List<Meal> results = mealRepo.findByPrice(12, MealRepo.PriceCond.LOWER);

        // then
        assertThat(results.size(), is (1));
    }

    @Test
    void shouldBeAbleToFindMealByPriceAndName() {
        // given
        mealRepo.add(new Meal(10, "Pizza"));
        mealRepo.add(new Meal(15, "Pizza+"));
        mealRepo.add(new Meal(1, "Carrot"));

        // when
        List<Meal> results = mealRepo.findByNameAndPrice("Pi", false, 10, MealRepo.PriceCond.GREATER);

        // then
        assertThat(results.size(), is(1));
    }

}
