package com.example;

class ReverseWord {
    String reverseWord(String input) {
        if (input.length() == 0) {
            throw new IllegalArgumentException("non-valid input");
        } else {
            StringBuilder result = new StringBuilder();
            for (int i = input.length() - 1; i >= 0; i--) {
                result.append(input.charAt(i));
            }
            return result.toString();
        }
    }
}