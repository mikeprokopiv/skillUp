package com.epam;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseWordTest {
    private final ReverseWord reverseWord = new ReverseWord();

    @Test
    public void reverseWord() {
        String result = reverseWord.reverseWord("Hello World");
        assertEquals("dlroW olleH", result);
    }

    @Test
    public void nonValidInput() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            reverseWord.reverseWord("");
        });
    }

    @Test
    public void wordWithCapitalLetters() {
        String result = reverseWord.reverseWord("HELLO world");
        assertEquals("dlrow OLLEH", result);
    }

    @Test
    public void singleWord() {
        String result = reverseWord.reverseWord("Hello");
        assertEquals("olleH", result);
    }

    @Test
    public void singleWordWithSpecChar() {
        String result = reverseWord.reverseWord("#Hello");
        assertEquals("olleH#", result);
    }

    @Test
    public void everyOtherLetterCapital() {
        String result = reverseWord.reverseWord("HeLlO");
        assertEquals("OlLeH", result);
    }

    @Test
    public void cyrylicWord() {
        String result = reverseWord.reverseWord("Привіт");
        assertEquals("тівирП", result);
    }
}
