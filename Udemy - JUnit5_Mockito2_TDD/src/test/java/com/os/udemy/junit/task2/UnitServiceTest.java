package com.os.udemy.junit.task2;

import static org.hamcrest.MatcherAssert.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.BDDMockito.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class UnitServiceTest {

    @Mock
    CargoRepository cargoRepository;

    @Mock
    UnitRepository unitRepository;

    @InjectMocks
    UnitService unitService;

    @Test
    void shouldAddNewCargo() {
        // given
        Coordinates coordinates = new Coordinates(10, 10);
        Unit unit = new Unit(coordinates, 10, 100);
        Cargo cargo = new Cargo("test", 20);
        given(cargoRepository.findCargoByName("test")).willReturn(Optional.of(cargo));

        // when
        unitService.addCargoByName(unit, "test");

        // then
        then(cargoRepository).should().findCargoByName("test");
        assertThat(unit.getLoad(), is(20));
    }

    @Test
    void shouldThrowISExceptionWhenCargoIsTooBig() {
        // given
        Coordinates coordinates = new Coordinates(10, 10);
        Unit unit = new Unit(coordinates, 10, 100);
        Cargo cargo = new Cargo("test", 101);
        given(cargoRepository.findCargoByName("test")).willReturn(Optional.of(cargo));

        // when + then
        assertThrows(IllegalStateException.class, () -> unitService.addCargoByName(unit, "test"));
    }

    @Test
    void shouldThrowNSEExceptionWhenCargoNotFound() {
        // given
        Coordinates coordinates = new Coordinates(10, 10);
        Unit unit = new Unit(coordinates, 10, 100);
        given(cargoRepository.findCargoByName("test")).willReturn(Optional.empty());

        // when + then
        assertThrows(NoSuchElementException.class, () -> unitService.addCargoByName(unit, "test"));
    }

    @Test
    void shouldThrowNSEExceptionWhenUnitNotFound() {
        // given
        Coordinates coordinates = new Coordinates(10, 10);
        given(unitRepository.getUnitByCoordinates(coordinates)).willReturn(null);

        // when + then
        assertThrows(NoSuchElementException.class, () -> unitService.getUnitOn(coordinates));
    }

    @Test
    void shouldReturnUnitWhenItExists() {
        // given
        Coordinates coordinates = new Coordinates(10, 10);
        Unit unit = new Unit(coordinates, 10, 100);
        given(unitRepository.getUnitByCoordinates(coordinates)).willReturn(unit);

        // when
        Unit unitReturned = unitService.getUnitOn(coordinates);

        // when
        then(unitRepository).should().getUnitByCoordinates(coordinates);
        assertThat(unitReturned, is(unit));
    }
}