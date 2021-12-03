package pl.allegro.tech.recruit.calc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DeveloperReputationCalculatorTest {

    private final DeveloperReputationCalculator calculator = new DeveloperReputationCalculator();
    private Developer dev;
    private ZonedDateTime nonOctober;
    private ZonedDateTime october;
    
    @BeforeEach
    void initialize() {
        Developer developer1 = new Developer("Dev1");
        Developer developer2 = new Developer("Dev2");
        dev = new Developer("Dev3", Arrays.asList(new Developer[] {developer1, developer2}));
        nonOctober = ZonedDateTime.of(2021, 01, 01, 0, 0, 0, 0, ZoneId.of("UTC"));
        october = ZonedDateTime.of(2021, 10, 12, 0, 0, 0, 0, ZoneId.of("UTC"));
    }
    
    @Test
    void shouldReturnNumberWhenHasDevelopersAndItsNotOctober() {
        // given + when
        int points = calculator.calculate(dev, nonOctober);
        
        // then
//        assumingThat(ZonedDateTime.now().getMonth() != Month.OCTOBER, () -> {
//            assertEquals(4, points);
//        });
        assertEquals(4, points);
        
    }
    
    @Test
    void shouldReturnZeroWhenNoDevelopersAndItsNotOctober() {
        // given
        Developer dev = new Developer("Test");
        
        // when
        int points = calculator.calculate(dev, nonOctober);
        
        // then
//        assumingThat(ZonedDateTime.now().getMonth() != Month.OCTOBER, () -> {
//            assertEquals(0, points);
//        });
        assertEquals(0, points);
    }
    
    @Test
    void shouldReturnNumberWhenHasDevelopersAndItsOctober() {
        // given + when
        int points = calculator.calculate(dev, october);
        
        // then
//        assumingThat(ZonedDateTime.now().getMonth() == Month.OCTOBER, () -> {
//            assertEquals(14, points);
//        });
        assertEquals(14, points);
    }
    
    @Test
    void shouldReturnHacktoberBonusWhenNoDevelopersAndItsOctober() {
        // given
        Developer dev = new Developer("Test");
        
        // when
        int points = calculator.calculate(dev, october);
        
        // then
//        assumingThat(ZonedDateTime.now().getMonth() == Month.OCTOBER, () -> {
//            assertEquals(10, points);
//        });
        assertEquals(10, points);
    }
    
    @Test
    void shouldReturnZeroWhenNullDeveloper() {
        
        // when
        int points = calculator.calculate(null);
        
        // then
//        assumingThat(ZonedDateTime.now().getMonth() == Month.OCTOBER, () -> {
//            assertEquals(10, points);
//        });
        assertThrows(NullPointerException.class, calculator.calculate(null));
    }
}
