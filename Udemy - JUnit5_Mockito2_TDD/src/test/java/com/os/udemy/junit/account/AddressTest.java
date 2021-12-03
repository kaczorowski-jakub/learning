package com.os.udemy.junit.account;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    @ParameterizedTest
    @CsvSource({"wesola, 10", "Armii Krajowej, 57/11", "'Romka, Tomka, Atomka',40"})
    void givenAddressesShouldNotBeEmptyAndHaveProperNames(String street, String number) {
        MatcherAssert.assertThat(street, Matchers.notNullValue());
        MatcherAssert.assertThat(street, Matchers.containsString("a"));
        MatcherAssert.assertThat(number, Matchers.notNullValue());
        MatcherAssert.assertThat(number.length(), Matchers.lessThan(30));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/addresses.csv")
    void addressesFromFileShouldNotBeEmptyAndHaveProperNames(String street, String number) {
        MatcherAssert.assertThat(street, Matchers.notNullValue());
        MatcherAssert.assertThat(street, Matchers.containsString("a"));
        MatcherAssert.assertThat(number, Matchers.notNullValue());
        MatcherAssert.assertThat(number.length(), Matchers.lessThan(30));
    }

}