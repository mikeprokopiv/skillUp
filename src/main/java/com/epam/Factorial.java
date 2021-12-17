package com.epam;

public class Factorial {
    public long factorial(int input) {
        long factorial = 1;
        for (int i = 2; i <= input; i++) {
            factorial *= i;
        }
        return factorial;
    }
}