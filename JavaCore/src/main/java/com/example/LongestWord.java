package com.example;

 class LongestWord {
    String longestWord(String input) {
        if (input.length() == 0) {
            throw new IllegalArgumentException("wrong input was entered");
        } else {
            String[] stringArray = input.split(" ");
            String longestWord = stringArray[0];
            for (String s : stringArray) {
                if (longestWord.length() < s.length())
                    longestWord = s;
            }
            System.out.println("Longest word is - " + longestWord);
            return longestWord;
        }
    }
}
