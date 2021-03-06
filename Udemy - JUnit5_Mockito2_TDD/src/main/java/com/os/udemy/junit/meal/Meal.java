package com.os.udemy.junit.meal;

import java.util.Objects;

public class Meal {
    private int price;
    private String name;
    private int quantity;

    public Meal() {

    }

    public Meal(int price) {
        this.price = price;
    }

    public Meal(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public Meal(int price, String name, int quantity) {
        this.price = price;
        this.name = name;
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public int getDiscountedPrice(int discount) {

        if (discount > this.price) {
            throw new IllegalArgumentException("Discount cannot be higher than the price");
        }
        return this.price - discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Meal)) return false;
        Meal meal = (Meal) o;
        return getPrice() == meal.getPrice() &&
                Objects.equals(name, meal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPrice(), name);
    }

    @Override
    public String toString() {
        return "Meal{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }

    public int getQuantity() {
        return quantity;
    }

    public int sumPrice() {
        return getPrice() *getQuantity();
    }

    public String getName() {
        return name;
    }
}
