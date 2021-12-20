package com.os.udemy.junit.task1;

import static org.hamcrest.MatcherAssert.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Coordinates Tests")
class CoordinatesTest {

    @Test
    void shouldThrowIAExceptionWhenXIsLessThanZero() {
        // given
        int x = -1;
        int y = 1;

        // when + then
        assertThrows(IllegalArgumentException.class, () -> new Coordinates(x, y));
    }

    @Test
    void shouldThrowIAExceptionWhenXIsGreaterThanHundred() {
        // given
        int x = 101;
        int y = 1;

        // when + then
        assertThrows(IllegalArgumentException.class, () -> new Coordinates(x, y));
    }

    @Test
    void shouldThrowIAExceptionWhenYIsLessThanZero() {
        // given
        int x = 1;
        int y = -1;

        // when + then
        assertThrows(IllegalArgumentException.class, () -> new Coordinates(x, y));
    }

    @Test
    void shouldThrowIAExceptionWhenYIsGreaterThanHundred() {
        // given
        int x = 1;
        int y = 101;

        // when + then
        assertThrows(IllegalArgumentException.class, () -> new Coordinates(x, y));
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
    void shouldThrowIAExceptionWhenCopyingCoordinatesWithXLessThanZero() {
        // given
        Coordinates coordinates = new Coordinates(0,0);

        // when + then
        assertThrows(IllegalArgumentException.class, () -> Coordinates.copy(coordinates, -10, 20));
    }

    @Test
    void shouldThrowIAExceptionWhenCopyingCoordinatesWithYLessThanZero() {
        // given
        Coordinates coordinates = new Coordinates(0,0);

        // when + then
        assertThrows(IllegalArgumentException.class, () -> Coordinates.copy(coordinates, 10, -10));
    }

    @Test
    void shouldThrowIAExceptionWhenCopyingCoordinatesWithXGreaterThanZero() {
        // given
        Coordinates coordinates = new Coordinates(0,0);

        // when + then
        assertThrows(IllegalArgumentException.class, () -> Coordinates.copy(coordinates, 101, 20));
    }

    @Test
    void shouldThrowIAExceptionWhenCopyingCoordinatesWithYGreaterThanZero() {
        // given
        Coordinates coordinates = new Coordinates(0,0);

        // when + then
        assertThrows(IllegalArgumentException.class, () -> Coordinates.copy(coordinates, 10, 101));
    }

    @Test
    void shouldThrowIAExceptionWhenCopyingAndExtendXorY() {
        // given
        Coordinates coordinates = new Coordinates(50,50);

        // when
        Coordinates copiedCoordinate = Coordinates.copy(coordinates, 50, 50);

        // then
        assertThat(copiedCoordinate.getX(), equalTo(100));
        assertThat(copiedCoordinate.getY(), equalTo(100));
    }
}