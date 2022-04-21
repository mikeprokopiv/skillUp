package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LongestWordTest {
    private final LongestWord longestWord = new LongestWord();

    @Test
    void sentenseWithFiveWords() {
        String result = longestWord.longestWord("required to support the mathematical");
        Assertions.assertEquals("mathematical", result);
    }

    @Test
    void emptyString() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            longestWord.longestWord("");
        });
    }

    @Test
    void sentenceWithTwoEqualLengthWords() {
        String result = longestWord.longestWord("and to are if");
        Assertions.assertEquals("and", result);
    }

}