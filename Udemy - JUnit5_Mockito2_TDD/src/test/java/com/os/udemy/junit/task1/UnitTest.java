package com.os.udemy.junit.task1;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;

class UnitTest {

    @Test
    void shouldThrowISExceptionWhenCargoIsMoreThanMax() {
        // given
        final Unit unit = new Unit(null, 10, 100);
        final Cargo heavyCargo = new Cargo("heavy", 1000);

        // when + then
        assertThrows(IllegalStateException.class, () -> unit.loadCargo(heavyCargo));
    }

    @Test
    void shouldCalculateTheCorrectCargoWeightWhenLoadingLessThanMax() {
        // given
        final Unit unit = new Unit(null, 10, 100);
        final Cargo lightCargo1 = new Cargo("heavy", 20);
        final Cargo lightCargo2 = new Cargo("heavy", 30);

        // when
        unit.loadCargo(lightCargo1);
        unit.loadCargo(lightCargo2);

        // then
        assertThat(unit.getLoad(), equalTo(50));
    }

    @Test
    void shouldCalculateTheCorrectCargoWeightWhenUnloadingNotLoadedCargo() {
        // given
        final Unit unit = new Unit(null, 10, 100);
        final Cargo lightCargo1 = new Cargo("heavy", 20);
        final Cargo lightCargo2 = new Cargo("heavy", 30);

        // when
        unit.loadCargo(lightCargo1);
        unit.unloadCargo(lightCargo2);
        // then
        assertThat(unit.getLoad(), equalTo(20));
    }

    @Test
    void shouldCalculateTheCorrectCargoWeightWhenUnloadingLoadedCargo() {
        // given
        final Unit unit = new Unit(null, 10, 100);
        final Cargo lightCargo1 = new Cargo("heavy", 20);
        final Cargo lightCargo2 = new Cargo("heavy", 30);

        // when
        unit.loadCargo(lightCargo1);
        unit.loadCargo(lightCargo2);
        unit.unloadCargo(lightCargo1);

        // then
        assertThat(unit.getLoad(), equalTo(30));
    }

    @Test
    void shouldCalculateTheCorrectCargoWeightWhenLoadingTheSameCargo() {
        // given
        final Unit unit = new Unit(null, 10, 100);
        final Cargo lightCargo1 = new Cargo("heavy", 20);

        // when
        unit.loadCargo(lightCargo1);
        unit.loadCargo(lightCargo1);

        // then
        assertThat(unit.getLoad(), equalTo(40));
    }

    @Test
    void shouldCalculateTheCorrectCargoWeightWhenUnloadingAll() {
        // given
        final Unit unit = new Unit(null, 10, 100);
        final Cargo lightCargo1 = new Cargo("heavy", 20);

        // when
        unit.loadCargo(lightCargo1);
        unit.loadCargo(lightCargo1);
        unit.unloadAllCargo();

        // then
        assertThat(unit.getLoad(), equalTo(0));
    }

    @Test
    void shouldThrowISExceptionWhenThereIsNotEnoughFuel() {
        // given
        final int maxFuel = 10;
        final Coordinates coordinates = new Coordinates(0,0);
        final Unit unit = new Unit(coordinates, maxFuel, 100);

        // when
        unit.move(2,2);
        unit.move(2,2);

        // then
        assertThrows(IllegalStateException.class, () -> unit.move(2,2));
    }

    @ParameterizedTest
    @MethodSource("createXandY")
    void shouldConsumeTheProperFuelUnitsAccordinglyToTheMove(int x, int y) {
        // given
        final int maxFuel = 100;
        final Coordinates coordinates = new Coordinates(0,0);
        final Unit unit = new Unit(coordinates, maxFuel, 100);

        // when
        unit.move(x, y);

        // then
        assertThat(unit.getFuel(), equalTo(maxFuel - x - y));
    }

    private static Stream<Arguments> createXandY() {
        Random r = new Random();
        Arguments arg1 = Arguments.of(r.nextInt(50), r.nextInt(50));
        Arguments arg2 = Arguments.of(r.nextInt(50), r.nextInt(50));
        Arguments arg3 = Arguments.of(r.nextInt(50), r.nextInt(50));
        return Stream.of(arg1, arg2, arg3);
    }

    @RepeatedTest(5)
    void shouldNeverExceedMaxFuelWhenTankUp() {
        // given
        final int maxFuel = 10;
        final Coordinates coordinates = new Coordinates(0,0);
        final Unit unit = new Unit(coordinates, maxFuel, 100);

        // when
        unit.move(2,2);
        unit.tankUp();

        // then
        assertThat(unit.getFuel(), lessThanOrEqualTo(maxFuel));

    }

}