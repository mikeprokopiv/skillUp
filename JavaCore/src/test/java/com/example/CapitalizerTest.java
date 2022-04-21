package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CapitalizerTest {
    private final Capitalizer cap = new Capitalizer();

    @Test
    void multipleWordValidInput() {
        String result = cap.capitalize("My example sentence");
        assertEquals("My Example Sentence ", result);
    }

    @Test
    void nonValidInput() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            cap.capitalize("");
        });
    }

    @Test
    void singleWordValidInput() {
        String result = cap.capitalize("example");
        assertEquals("Example ", result);
    }

    @Test
    void inputWithSpecChar() {
        String result = cap.capitalize("#my $example %sentence");
        assertEquals("#my $example %sentence ", result);
    }
}