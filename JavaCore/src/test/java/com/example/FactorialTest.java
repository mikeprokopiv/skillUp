package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FactorialTest {
    private final Factorial f = new Factorial();

    @Test
    void digitBigerThanInt() {
        long result = f.factorial(14);
        assertEquals(87178291200L, result);
    }

    @Test
    void digitLessThanInt() {
        long result = f.factorial(5);
        assertEquals(120, result);
    }
}