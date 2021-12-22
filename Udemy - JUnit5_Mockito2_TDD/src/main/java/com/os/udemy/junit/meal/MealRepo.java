package com.os.udemy.junit.meal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MealRepo {

    private final List<Meal> meals = new ArrayList<>();

    public void add(Meal meal) {
        meals.add(meal);
    }

    public List<Meal> getAllMeals() {
        return meals;
    }

    public void delete(Meal meal) {
        meals.remove(meal);
    }

    public List<Meal> findByName(String mealName, boolean exactMatch) {
        return meals.stream()
                .filter(meal -> exactMatch ? meal.getName().equals(mealName) : meal.getName().startsWith(mealName))
                .collect(Collectors.toList());
    }
    public List<Meal> findByPrice(int price) {
        return findByPrice(price, PriceCond.EQUAL);
    }

    public List<Meal> findByPrice(int price, PriceCond cond) {
        return meals.stream()
                .filter(meal -> {
                    switch (cond) {
                        case EQUAL: return meal.getPrice() == price;
                        case GREATER: return meal.getPrice() > price;
                        case LOWER: return meal.getPrice() < price;
                        default: return false;
                    }
                })
                .collect(Collectors.toList());
    }

    public List<Meal> findByNameAndPrice(String name, boolean exactMatch, int price, PriceCond cond) {
        List<Meal> filterMeals = findByName(name, exactMatch);
        List<Meal> filterMeals2 = findByPrice(price, cond);

        return filterMeals.stream().filter(meal -> filterMeals2.contains(meal)).collect(Collectors.toList());
    }

    public enum PriceCond {
        EQUAL, GREATER, LOWER
    }
}
