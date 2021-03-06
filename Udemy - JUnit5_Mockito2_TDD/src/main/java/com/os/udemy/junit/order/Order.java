package com.os.udemy.junit.order;

import com.os.udemy.junit.meal.Meal;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Meal> meals = new ArrayList<>();
    private OrderStatus orderStatus;

    public void addMealToOrder(Meal meal) {
        this.meals.add(meal);
    }

    public void removeMealFromOrder(Meal meal) {
        this.meals.remove(meal);
    }

    public List<Meal> getMeals() {
        return meals;
    }

    void cancel() {
        this.meals.clear();
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public int totalPrice() {
        int sum = this.meals.stream().mapToInt(meal -> meal.getPrice()).sum();

        if (sum < 0) {
            throw new IllegalStateException("Sum exceeded!" + sum);
        }

        return sum;
    }

    public void chaneOrderStatus(OrderStatus newOrderStatus) {
        this.orderStatus = newOrderStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "meals=" + meals +
                '}';
    }
}
