package com.epam;

public class Capitalizer {
    public String capitalize(String input) {
        if (input.length() == 0) {
            throw new IllegalArgumentException("input is not valid");
        } else {
            String[] ArrayString = input.split(" ");
            StringBuilder result = new StringBuilder();
            for (String s : ArrayString) {
                String temp = s.substring(0, 1).toUpperCase() + s.substring(1);
                result.append(temp).append(" ");
            }
            return result.toString();
        }
    }
}