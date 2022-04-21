package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseWordTest {
    private final ReverseWord reverseWord = new ReverseWord();

    @Test
    void reverseWord() {
        String result = reverseWord.reverseWord("Hello World");
        assertEquals("dlroW olleH", result);
    }

    @Test
    void nonValidInput() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            reverseWord.reverseWord("");
        });
    }

    @Test
    void wordWithCapitalLetters() {
        String result = reverseWord.reverseWord("HELLO world");
        assertEquals("dlrow OLLEH", result);
    }

    @Test
    void singleWord() {
        String result = reverseWord.reverseWord("Hello");
        assertEquals("olleH", result);
    }

    @Test
    void singleWordWithSpecChar() {
        String result = reverseWord.reverseWord("#Hello");
        assertEquals("olleH#", result);
    }

    @Test
    void everyOtherLetterCapital() {
        String result = reverseWord.reverseWord("HeLlO");
        assertEquals("OlLeH", result);
    }

    @Test
    void cyrillicWord() {
        String result = reverseWord.reverseWord("Привіт");
        assertEquals("тівирП", result);
    }
}
