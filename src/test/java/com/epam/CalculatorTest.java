package com.epam;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {
    Calculator c = new Calculator();

    @Test
    void summarization() {
        int result = c.summarization(5, 6);
        assertEquals(11, result);
    }

    @Test
    void subtraction() {
        int result = c.subtraction(10, 5);
        assertEquals(5, result);
    }

    @Test
    void division() {
        int result = c.division(1000, 125);
        assertEquals(8, result);
    }

    @Test
    void divisionToZero() {
        int result = c.division(1000, 0);
        assertEquals(0, result);
    }

    @Test
    void multiplication() {
        int result = c.multiplication(25, 4);
        assertEquals(100, result);
    }
}