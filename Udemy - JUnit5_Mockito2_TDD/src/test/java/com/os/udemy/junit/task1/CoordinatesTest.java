package com.os.udemy.junit.task1;

import static org.hamcrest.MatcherAssert.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Coordinates Tests")
class CoordinatesTest {

    @Test
    void shouldThrowIAExceptionWhenXorYOutOfBound() {
        // given + when + then
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> new Coordinates(-1, -1)),
                () -> assertThrows(IllegalArgumentException.class, () -> new Coordinates(101, 1))
        );

    }

    @Test
    void shouldCreateAnObjectWhenXandYInBound() {
        // given + when
        Coordinates coordinates = new Coordinates(10,10);

        // then
        assertThat(coordinates.getX(), equalTo(10));
        assertThat(coordinates.getY(), equalTo(10));
    }

    @Test
    void shouldThrowIAExceptionWhenCopyingAndExtendXorY() {
        // given
        Coordinates coordinates = new Coordinates(80,90);

        // when + then
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> Coordinates.copy(coordinates, 10, 20)),
                () -> assertThrows(IllegalArgumentException.class, () -> Coordinates.copy(coordinates, 30, 5))
        );

    }

}