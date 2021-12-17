package com.epam;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.assertEquals;

public class LongestWordTest {
    private final LongestWord longestWord = new LongestWord();

    @Test
    public void sentenseWithFiveWords() {
        String result = longestWord.longestWord("required to support the mathematical");
        assertEquals("mathematical", result);
    }

    @Test
    public void emptyString() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            longestWord.longestWord("");
        });
    }

    @Test
    public void sentenceWithTwoEqualLengthWords() {
        String result = longestWord.longestWord("and to are if");
        assertEquals("and", result);
    }

}