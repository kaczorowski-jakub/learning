package com.os.udemy.junit.order;

import com.os.udemy.junit.Meal;
import com.os.udemy.junit.order.Order;
import com.os.udemy.junit.order.OrderBackup;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class OrderBackupTest {

    static private OrderBackup orderBackup;

    @BeforeEach
    void appendAtTheStartOfTheLine() throws IOException {
        orderBackup.getWriter().append("new order");
    }

    @AfterEach
    void appendAtTheEndOfTheLine() throws IOException {
        orderBackup.getWriter().append(" END");
    }

    @BeforeAll
    static void setup() throws IOException {
        orderBackup = new OrderBackup();
        orderBackup.createFile();
    }

    @AfterAll
    static void tearDown() throws IOException {
        orderBackup.closeFile();
    }

    @Tag("fries")
    @Test
    void backupOrderWithOneMeal() throws IOException {
        // given
        Meal meal = new Meal(8, "fires");
        Order order = new Order();
        order.addMealToOrder(meal);

        // when
        orderBackup.backupOrder(order);

        // then
        System.out.println("Order: " + order.toString() + "backed up");
    }
}
