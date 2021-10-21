package com.os.junit.test.main;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MathMethodsTest {
    
    MathMethods mm;
    
    @BeforeEach
    public void init() {
        mm = new MathMethods();
    }
    
    @Test
    public void fib_happyPath10_success() {
        assertEquals(55, mm.fib(10));
    }
    
    @Test
    public void fib_happyPath0_success() {
        assertEquals(0, mm.fib(0));
    }
    
    @Test
    public void fib_happyPath1_success() {
        assertEquals(1, mm.fib(1));
    }
    
    @Test
    public void fib_happyPath2_success() {
        assertEquals(1, mm.fib(2));
    }
    
    @Test
    public void fib_negativeValue_exception() {
        assertThrows(RuntimeException.class, () -> mm.fib(-100));
    }
    
    @Test
    public void luc_happyPathWithFirst5element_success() {
        assertAll("luc first 5 elements",
                () -> assertEquals(2, mm.luc(0)),
                () -> assertEquals(1, mm.luc(1)),
                () -> assertEquals(3, mm.luc(2)),
                () -> assertEquals(4, mm.luc(3)),
                () -> assertEquals(7, mm.luc(4)));
    }
    
}
